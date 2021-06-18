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
