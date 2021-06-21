package com.example.staffhouse.dao;

import com.example.staffhouse.entity.UserInfo;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testGetUserInfoByLoginName(){
        String loginName="123";
        UserInfo userInfo=userDao.getUserInfoByLoginName(loginName);
        JSONObject jsonObject=JSONObject.fromObject(userInfo);
        System.out.println(jsonObject);
    }

    @Test
    public void testUpdateUserPassword(){
        UserInfo userInfo=new UserInfo();
        userInfo.setLoginName("123");
        userInfo.setPassword("12");

        userDao.updateUserPassword(userInfo);
    }
}
