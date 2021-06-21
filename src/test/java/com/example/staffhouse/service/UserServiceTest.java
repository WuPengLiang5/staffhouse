package com.example.staffhouse.service;

import com.example.staffhouse.entity.UserInfo;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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

    @Test
    public void testListUserInfo(){
        List<UserInfo> userList = userService.listUserInfo();
        JSONObject jsonObject=JSONObject.fromObject(userList);
        System.out.println(jsonObject);
    }

    @Test
    public void testListUserInfoByStatus(){
        List<UserInfo> userList = userService.listUserInfoByUserStatus(1);
        JSONObject jsonObject=JSONObject.fromObject(userList);
        System.out.println(jsonObject);
    }

    @Test
    public void testGetUserInfoByUserName(){
        String userName ="武朋亮";
        List<UserInfo> userList = userService.getUserInfoByUserName(userName);
        JSONObject jsonObject=JSONObject.fromObject(userList);
        System.out.println(jsonObject);
    }

    @Test
    public void testUpdateUserInfoById(){
        UserInfo userInfo=new UserInfo();
        userInfo.setId(1);
        userInfo.setLoginName("123");
        userInfo.setStatus(1);
        userInfo.setUserName("吴亮");
        userService.updateUserInfoById(userInfo);
    }

    @Test
    public void testDeleteUserById(){
        userService.deleteUserById(1);
    }

    @Test
    public void testSaveUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setLoginName("123");
        userInfo.setPassword("123456");
        userInfo.setStatus(1);
        userInfo.setUserName("陈佳明");
        userService.saveUserInfo(userInfo);
    }
}
