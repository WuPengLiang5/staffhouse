package com.example.staffhouse.controller;


import com.example.staffhouse.entity.Notice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
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

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class NoticeControllerTest {


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
     * 公告数据列表
     */
    @Test
    public void listNotice(){
        System.out.println("listNotice test start....");
        try {
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/notice/listNotice")
                    .accept("application/json;charset=utf-8"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();;
        }
    }

    /**
     * 根据创建日期获取公告
     */
    @Test
    public void listNoticeByCreateDate(){
        System.out.println("listNoticeByCreateDate test start....");
        try{
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/notice/listNoticeByCreatDate")
                    .accept("application/json;charset=utf-8"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据员工获取列表
     */
    @Test
    public void listNoticeUserId(){

        System.out.println("listNoticeByCreateDate test start....");
        try{
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/notice/listNoticeByUserId")
                            .accept("application/json;charset=utf-8"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 公告保存
     */
    @Test
    public void saveNotice(){
        System.out.println("listNoticeByCreateDate test start....");
        try{
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/notice/saveNotice")
                            .accept("application/json;charset=utf-8")
                            .param("id","1111")
                            .param("userId","1")
                            .param("title","HelloWorld")
                            .param("content","lalalalalala.")
                            .param("createDate","2021/06/20"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 删除公告
     */
    @Test
    public void deleteNotice(){
        System.out.println("listNoticeByCreateDate test start....");
        try{
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/notice/deleteNotice")
                            .accept("application/json;charset=utf-8")
                            .param("id","1111"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 修改公告
     */
    @Test
    public void updateNotice(){
        System.out.println("listNoticeByCreateDate test start....");
        try{
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/notice/updateNotice")
                            .accept("application/json;charset=utf-8")
                            .param("id","1111")
                            .param("title","HelloWorld1")
                            .param("content","lalalalalalahohoh.")
                            .param("createDate","2021/06/20.1"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
