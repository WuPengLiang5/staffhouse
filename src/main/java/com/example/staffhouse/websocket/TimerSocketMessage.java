package com.example.staffhouse.websocket;

import com.example.staffhouse.entity.NoticeDTO;
import com.example.staffhouse.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@EnableScheduling
public class TimerSocketMessage {

    @Autowired
    private WebSocketServer webSocket;

    @Autowired
    private NoticeService noticeService;

    /**
     * 推送消息到前台
     */
    @Scheduled(cron = "*/10 * * * * * ")
    public void SocketMessage(){
        List<NoticeDTO> noticeList=noticeService.listNotice();
        webSocket.sendAllMessage(noticeList);
    }
}
