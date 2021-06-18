package com.example.staffhouse.service;

import com.example.staffhouse.entity.UserInfo;

import java.util.List;

public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<UserInfo> listUserInfo();
    /*通过权限查询用户*/

    public List<UserInfo> listUserInfoByUserStatus(int status);

    /*通过用户名查询用户*/
    public UserInfo getUserInfoByUserName(String userName);

    /*修改用户信息*/
    public void updateUserInfoById(UserInfo userInfo);

    /*增加用户*/
    public void saveUserInfo(UserInfo userInfo);

    /**
     * 根据id拿到登录用户的最新信息
     * @param loginName
     * @return
     */
    public UserInfo getUserByLoginName(String loginName);
}
