package com.example.staffhouse.websocket;

import com.example.staffhouse.entity.NoticeDTO;
import com.example.staffhouse.service.NoticeService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

@Controller
@Component
@ServerEndpoint("/websocket/{userId}")
public class WebSocketServer {
    /**与某个客户端的连接会话，需要通过它来给客户端发送数据*/
    private Session session;
    public static CopyOnWriteArraySet<WebSocketServer> webSockets =new CopyOnWriteArraySet<>();
    private static Map<String,Session> sessionPool = new HashMap<String,Session>();


    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value="userId")String userId) {
        this.session = session;
        webSockets.add(this);
        sessionPool.put(userId, session);
        // Constants.WEBSOCKET = true;//定义常量  是否开启websocket连接
        System.out.println("【websocket消息】有新的连接，总数为:"+webSockets.size());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSockets.remove(this);
        //Constants.WEBSOCKET = false;
        System.out.println("【websocket消息】连接断开，总数为:"+webSockets.size());
    }

    /**
     * 收到客户端消息后调用的方法,客户端发送过来的消息
     *
     * @param message
     */
    @OnMessage
    public void onMessage(String message) {
        System.out.println("【websocket消息】收到客户端消息:"+message);
        if (message.equals("更新数据")){
            List<NoticeDTO> noticeList=getMessageService().listNotice();
            sendAllMessage(noticeList);
        }
    }

    /**
     * 出现错误
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     * 此为广播消息
     * @param message
     */
    public void sendAllMessage(List<NoticeDTO> message) {
        for(WebSocketServer webSocket : webSockets) {
//            System.out.println("【websocket消息】广播消息:"+message);
            try {
                JSONArray jsonArray=JSONArray.fromObject(message);
                webSocket.session.getAsyncRemote().sendText(jsonArray.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 此为单点消息
    public void sendOneMessage(String userId, String message) {
        Session session = sessionPool.get(userId);
        System.out.println(userId);
        /*在发送数据之前先确认 session是否已经打开 使用session.isOpen() 为true 则发送消息
         * 不然会报错:The WebSocket session [0] has been closed and no method (apart from close()) may be called on a closed session */
//        if (session != null && session.isOpen()) {
//            try {
//                session.getAsyncRemote().sendText(message);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        try {
            session.getBasicRemote().sendText(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public NoticeService getMessageService() {
        return FrameSpringBeanUtil.getBean(NoticeService.class);
    }
}
