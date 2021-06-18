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

    UserInfo getUserInfoByLoginName(@Param("loginName")String loginName);

}
