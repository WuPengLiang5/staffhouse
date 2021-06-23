package com.example.staffhouse.controller;


import com.example.staffhouse.entity.Notice;
import com.example.staffhouse.entity.UserInfo;
import com.example.staffhouse.util.FileUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
import com.example.staffhouse.controller.LoginControllerTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class NoticeControllerTest {


    @Autowired
    public WebApplicationContext wac;

    public MockMvc mockMvc;

    public MockHttpSession session;

    public void login(){
        try {
            UserInfo userInfo=new UserInfo();
            userInfo.setLoginName("123");
            userInfo.setPassword("123");
            //设置值
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
            String requestJson=ow.writeValueAsString(userInfo);
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.post("/login/doLogin")
                            .contentType(MediaType.APPLICATION_JSON).content(requestJson)
                            .accept("application/json;charset=utf-8"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            JSONObject jsonObject1=JSONObject.fromObject(mvcResult.getResponse().getContentAsString());
            FileUtil.WriteStringToFile((String) jsonObject1.get("token"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("-------------------------------------------------------------------");
    }

    @Before
    public void init(){
        System.out.println("before...");
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        session = new MockHttpSession();
        login();
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
            String token = FileUtil.readTokenFile();
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/notice/listNoticeByCreatDate")
                    .accept("application/json;charset=utf-8")
                    .header("token",token))
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
            String token = FileUtil.readTokenFile();
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/notice/listNoticeByUserId")
                            .accept("application/json;charset=utf-8")
                            .header("token",token))
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
            String token = FileUtil.readTokenFile();
            Notice notice = new Notice(111,1,"dasdas","都护府","2020/2/2");
            JSONObject jsonObject = JSONObject.fromObject(notice);
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/notice/saveNotice")
                           .contentType(MediaType.APPLICATION_JSON).content(String.valueOf(jsonObject))
                            .accept("application/json;charset=utf-8")
                            .header("token",token))
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
            String token = FileUtil.readTokenFile();
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/notice/deleteNotice")
                            .accept("application/json;charset=utf-8")
                            .header("token",token)
                            .param("id","111"))
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
            Notice notice = new Notice(111,1,"bbbbbb","都护府","2020/2/2");
            JSONObject jsonObject = JSONObject.fromObject(notice);
            String token = FileUtil.readTokenFile();
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/notice/updateNotice")
                            .contentType(MediaType.APPLICATION_JSON).content(String.valueOf(jsonObject))
                            .accept("application/json;charset=utf-8")
                            .header("token",token))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteNoticeByQuery(){
        Map<String,List<Integer>> map = new HashMap<>();
        List<Integer>  ids = new ArrayList<>();
        ids.add(111);
        map.put("ids",ids);
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        try{
            String token = FileUtil.readTokenFile();
            String requestJson=ow.writeValueAsString(map);
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/notice/deleteNoticeByQuery")
                            .contentType(MediaType.APPLICATION_JSON).content(requestJson)
                            .accept("application/json;charset=utf-8")
                            .header("token",token))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void searchNotice(){
        Map<String,String> map = new HashMap<>();
        String title = "标题";
        map.put("title",title);
        map.put("content","");
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        try{
            String token = FileUtil.readTokenFile();
            String requestJson=ow.writeValueAsString(map);
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/notice/searchNotice")
                            .contentType(MediaType.APPLICATION_JSON).content(requestJson)
                            .accept("application/json;charset=utf-8")
                            .header("token",token))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
