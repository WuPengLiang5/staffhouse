package com.example.staffhouse.service;

import com.example.staffhouse.entity.PathDTO;
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

    /**
     * 将图片写入硬盘
     * @param base
     * @param path
     * @param urlPath
     * @param loginUser
     * @return
     */
    public PathDTO writeImgToDisc(String base, String path, String urlPath, UserInfo loginUser);

    /**
     * 更新人脸数据
     * @param pathDTO
     * @param loginUser
     */
    public void updateUserFace(PathDTO pathDTO, UserInfo loginUser);
}
