package com.example.staffhouse.controller;

import com.example.staffhouse.entity.UserInfo;
import com.example.staffhouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author NIIT
 */
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
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
}
