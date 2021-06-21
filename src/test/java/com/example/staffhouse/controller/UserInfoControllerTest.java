package com.example.staffhouse.controller;

import com.example.staffhouse.entity.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserInfoControllerTest {

    @Autowired
    public WebApplicationContext wac;

    public MockMvc mockMvc;

    public MockHttpSession session;

    @Before
    public void init(){
        System.out.println("before...");
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        session = new MockHttpSession();
    }

    /**
     * 测试ListUserInfo方法
     */
    @Test
    public void testListUserInfo(){
        System.out.println("listUserInfo test start....");
        try {
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/user/listUserInfo")
                            .accept("application/json;charset=utf-8"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();;
        }
    }

    /**
     * 测试ListUserInfoByStatus方法
     */
    @Test
    public void testListUserInfoByStatus(){
        System.out.println("listUserInfoByStatus test start....");
        try {
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.post("/user/listUserInfoByStatus")
                            .param("status","1")
                            .accept("application/json;charset=utf-8"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();;
        }
    }

    /**
     * 测试getUserInfoByUserName方法
     */
    @Test
    public void testGetUserInfoByUserName(){
        System.out.println("getUserInfoByUserName test start....");
        try {
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.post("/user/getUserInfoByUserName")
                            .param("userName","黄涛")
                            .accept("application/json;charset=utf-8"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();;
        }
    }

    /**
     * 测试updateUserInfoById方法
     */
    @Test
    public void testUpdateUserInfoById(){
        System.out.println("updateUserInfoById test start....");
        try {
            UserInfo userInfo=new UserInfo();
            userInfo.setId(1);
            userInfo.setLoginName("123");
            userInfo.setStatus(1);
            userInfo.setUserName("吴亮");
            //设置值
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
            String requestJson=ow.writeValueAsString(userInfo);

            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.post("/user/updateUserInfoById")
                            .contentType(MediaType.APPLICATION_JSON).content(requestJson)
                            .accept("application/json;charset=utf-8"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();;
        }
    }

    /**
     * 测试deleteUserById方法
     */
    @Test
    public void testDeleteUserById(){
        System.out.println("deleteUserById test start....");
        try {
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.post("/user/deleteUserById")
                            .param("id","9")
                            .accept("application/json;charset=utf-8"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();;
        }
    }

    /**
     * 测试saveUserInfo方法
     */
    @Test
    public void testSaveUserInfo(){
        System.out.println("saveUserInfo test start....");
        try {
            UserInfo userInfo=new UserInfo();
            userInfo.setLoginName("123");
            userInfo.setPassword("123456");
            userInfo.setStatus(1);
            userInfo.setUserName("陈佳明");
            //设置值
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
            String requestJson=ow.writeValueAsString(userInfo);

            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.post("/user/saveUserInfo")
                            .contentType(MediaType.APPLICATION_JSON).content(requestJson)
                            .accept("application/json;charset=utf-8"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();;
        }
    }
}