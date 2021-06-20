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
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class LoginControllerTest {

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

    @Test
    public void testLogin() {
        try {
            UserInfo userInfo=new UserInfo();
            userInfo.setLoginName("123");
            userInfo.setPassword("12");
            //设置值
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
            String requestJson=ow.writeValueAsString(userInfo);
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.post("/login/doLogin")
                            .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            System.out.println(mvcResult);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateUserPassword() {
        try {
            Map<String,String> map=new HashMap<>();
            map.put("loginName","123");
            map.put("password","12");
            map.put("newPassword","12");
            //设置值
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
            String requestJson=ow.writeValueAsString(map);
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.post("/login/doLogin")
                            .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            System.out.println(mvcResult);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}