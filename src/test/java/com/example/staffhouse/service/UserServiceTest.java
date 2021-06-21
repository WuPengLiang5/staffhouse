package com.example.staffhouse.service;

import com.example.staffhouse.entity.UserInfo;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 用户业务层接口的单元测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testGetUserByLoginName(){
        String loginName="123";
        UserInfo userInfo=userService.getUserByLoginName(loginName);
        JSONObject jsonObject=JSONObject.fromObject(userInfo);
        System.out.println(jsonObject);
    }

    @Test
    public void testUpdateUserPassword(){
        UserInfo userInfo=new UserInfo();
        userInfo.setLoginName("123");
        userInfo.setPassword("12");

        userService.updateUserPassword(userInfo);
    }
}
