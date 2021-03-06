package com.example.staffhouse.controller;

import com.example.staffhouse.entity.UserInfo;
import com.example.staffhouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserService userService;

    /**
     * 获得所有用户信息
     */

    @RequestMapping("/listUserInfo")
    public List<UserInfo> listUserInfo(){
        return userService.listUserInfo();
    }
    /**
     *  根据权限获得所有用户信息
     */

    @RequestMapping("/listUserInfoByStatus")
    public List<UserInfo> listUserInfoByStatus(@RequestParam int status){
        return userService.listUserInfoByUserStatus(status);
    }

    /**
     * 根据用户名获得用户信息
     * @param userName
     * @return
     */
    @RequestMapping("/getUserInfoByUserName")
    public List<UserInfo> listUserInfoByStatus(@RequestParam String userName){
        return userService.getUserInfoByUserName(userName);
    }

    /**
     * 根据用户id修改用户信息
     * @param userInfo
     */
    @RequestMapping("/updateUserInfoById")
    public void updateUserInfoById(@RequestBody UserInfo userInfo){
        userService.updateUserInfoById(userInfo);
    }

    /**
     * 根据id删除用户
     * @param id
     */
    @RequestMapping("/deleteUserById")
    public void deleteUserById(@RequestParam int id){
        userService.deleteUserById(id);
    }

    /**
     * 添加用户
     * @param userInfo
     */
    @RequestMapping("/saveUserInfo")
    public int saveUserInfo(@RequestBody UserInfo userInfo){
        return userService.saveUserInfo(userInfo);
    }
}
