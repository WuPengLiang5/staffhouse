package com.example.staffhouse.service;

import com.example.staffhouse.entity.UserInfo;

import java.util.List;

public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<UserInfo> listUserInfo();

    /**
     * 根据id拿到登录用户的最新信息
     * @param loginName
     * @return
     */
    public UserInfo getUserByLoginName(String loginName);

    /**
     * 人脸登录
     * @param base
     * @return
     */
    public UserInfo faceLogin(String base);
}
