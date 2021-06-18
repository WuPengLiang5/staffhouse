package com.example.staffhouse.controller;

import com.example.staffhouse.entity.UserInfo;
import com.example.staffhouse.service.UserService;
import com.example.staffhouse.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public UserInfo login(HttpSession session,UserInfo userInfo){
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
