package com.example.staffhouse.controller;

import com.example.staffhouse.entity.PathDTO;
import com.example.staffhouse.entity.UserInfo;
import com.example.staffhouse.entity.Message;
import com.example.staffhouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author NIIT
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     *
     * @param session
     * @param userInfo
     * @return
     */
    @RequestMapping("/doLogin")
    public UserInfo login(HttpSession session, UserInfo userInfo){
        UserInfo user = userService.getUserByLoginName(userInfo.getLoginName());
        String rawPassword = userInfo.getPassword();
        System.out.println(user.getLoginName());
        String rightPassword = user.getPassword();
        System.out.println(rightPassword);
        if (rawPassword.equalsIgnoreCase(rightPassword)){
            session.setAttribute("user", user);
            return user;
        }
        else{
            UserInfo user_not = new UserInfo();
            user_not.setStatus(-1);
            user_not.setUserName("notfound");
            user_not.setLoginName("notfound");
            return user_not;
        }
//        if (MD5Util.verify(rawPassword, rightPassword)){
//            // 写入session 用户的id和用户的权限
//            session.setAttribute("user", user);
////            System.out.println("登录成功！");
//            return user;
//        }
//        else{
//            UserInfo user_not = new UserInfo();
//            user_not.setStatus(-1);
//            user_not.setUserName("notfound");
//            user_not.setLoginName("notfound");
//            return user_not;
//        }
    }

    /**
     * 人脸登录
     * @param base
     * @param session
     * @return
     */
    @RequestMapping("/faceLogin")
    public Message faceLogin(String base, HttpSession session){
        UserInfo loginUser = userService.faceLogin(base);
        Message message = new Message();
        message.setMessage("login");
        if(loginUser != null){
            //登录成功
            session.setAttribute("loginUser", loginUser);
            message.setMessage("index");
            return message;
        }
        return message;
    }

    /**
     * 人脸注册
     * @param base
     * @param request
     * @return
     */
    @RequestMapping("/faceRegister")
    public @ResponseBody Message faceRegister(String base, HttpServletRequest request){
        UserInfo loginUser = (UserInfo) request.getSession().getAttribute("loginUser");
        //把用户照片保存到本地
        String path = request.getServletContext().getRealPath("/") + "headphoto\\";
        String urlPath = request.getContextPath() + "/headphoto/" + loginUser.getId() + ".jpg";
        PathDTO pathDTO = userService.writeImgToDisc(base, path, urlPath, loginUser);
        //更新人脸信息
        userService.updateUserFace(pathDTO,loginUser);
        //生成返回信息
        Message message = new Message();
        message.setMessage("注册成功");
        return message;
    }
}
