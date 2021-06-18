package com.example.staffhouse.controller;

import com.example.staffhouse.entity.UserInfo;
import com.example.staffhouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserService userService;

    /*获得所有用户信息*/
    @RequestMapping("/listUserInfo")
    public List<UserInfo> listUserInfo(){
        return userService.listUserInfo();
    }
    /*根据权限获得所有用户信息*/
    @RequestMapping("/listUserInfoByStatus")
    public List<UserInfo> listUserInfoByStatus(@RequestParam int status){
        return userService.listUserInfoByUserStatus(status);
    }

    /*根据用户名获得用户信息*/
    @RequestMapping("/getUserInfoByUserName")
    public UserInfo listUserInfoByStatus(@RequestParam String userName){
        return userService.getUserInfoByUserName(userName);
    }
}
