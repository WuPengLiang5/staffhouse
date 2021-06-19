package com.example.staffhouse.dao;

import com.example.staffhouse.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value="UserDao")
public interface UserDao {
    List<UserInfo> listUserInfo();

    List<UserInfo> listUserInfoByUserStatus(int status);

    UserInfo getUserInfoByUserName(String userName);

    int updateUserInfoById(UserInfo userInfo);

    int saveUserInfo(UserInfo userInfo);

    int deleteUserById(int id);

    UserInfo getUserInfoByLoginName(@Param("loginName")String loginName);


}
