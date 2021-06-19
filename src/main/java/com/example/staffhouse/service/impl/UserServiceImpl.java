package com.example.staffhouse.service.impl;

import com.example.staffhouse.util.FileUtil;
import com.example.staffhouse.dao.UserDao;
import com.example.staffhouse.entity.PathDTO;
import com.example.staffhouse.entity.UserInfo;
import com.example.staffhouse.service.UserService;
import com.example.staffhouse.util.FaceClient;
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
    public UserInfo getUserInfoById(Integer userId) {
        return userDao.getUserInfoById(userId);
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
        List<UserInfo> users = listUserInfo();
        FaceClient client = FaceClient.getInstance();
        for(UserInfo user : users){
            if(user.getFacePath() != null && !"".equals(user.getFacePath())){
                //获得每一个用户的照片的base64编码的字符串
                String base1 = FileUtil.getImageStr(user.getFacePath());
                boolean login = client.faceCompare(base, base1);
                if(login){
                    return user;
                }
            }
        }
        return null;
    }

    /**
     * 将图片写入硬盘
     * @param base
     * @param path
     * @param urlPath
     * @param loginUser
     * @return
     */
    @Override
    public PathDTO writeImgToDisc(String base, String path, String urlPath, UserInfo loginUser) {
        return null;
    }

    /**
     * 更新人脸数据
     * @param pathDTO
     * @param loginUser
     */
    @Override
    public void updateUserFace(PathDTO pathDTO, UserInfo loginUser) {

    }

    /**
     * 更新密码
     * @param userInfo
     */
    @Override
    public void updateUserPassword(UserInfo userInfo) {
        userDao.updateUserPassword(userInfo);
    }
}
