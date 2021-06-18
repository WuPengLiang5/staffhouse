package com.example.staffhouse.service.impl;

import com.example.staffhouse.dao.UserDao;
import com.example.staffhouse.entity.UserInfo;
import com.example.staffhouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<UserInfo> listUserInfo() {
        return userDao.listUserInfo();
    }

    @Override
    public List<UserInfo> listUserInfoByUserStatus(int status) {
        return userDao.listUserInfoByUserStatus(status);
    }

    @Override
    public UserInfo getUserInfoByUserName(String userName) {
        return userDao.getUserInfoByUserName(userName);
    }

    @Override
    public void updateUserInfoById(UserInfo userInfo) {
         userDao.updateUserInfoById(userInfo);
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        userDao.saveUserInfo(userInfo);
    }

    @Override
    public UserInfo getUserByLoginName(String loginName) {
        return userDao.getUserInfoByLoginName(loginName);
    }

    /**
     * 人脸登录
     * @param base
     * @return
     */
    @Override
    public UserInfo faceLogin(String base) {
        return null;
    }
}
