package com.example.staffhouse.controller;

import com.example.staffhouse.entity.EmployeeInf;
import com.example.staffhouse.entity.JobInf;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JobControllerTest {
    @Autowired
    public WebApplicationContext wac;

    public MockMvc mockMvc;

    public MockHttpSession session;
    @Before
    public void init(){
        System.out.println("before......");
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        session = new MockHttpSession();
    }

    @Test
    public void query(){
        try {
            mockMvc.perform(
                    MockMvcRequestBuilders.get("/job/getAllJobsByLike")
                            .param("page","1")
                            .param("limit","5")
                            .accept("application/json;charset=utf-8")
            ).andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void edit(){
        JobInf job = JobInf.builder()
                .id(3)
                .name("junit修改测试-job")
                .build();
        try{
            mockMvc.perform(
                    MockMvcRequestBuilders.put("/job/editJob")
                            .accept("application/json;charset=utf-8")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content( new ObjectMapper().writeValueAsString(job))
            ).andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn().getResponse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void add(){
        JobInf job = JobInf.builder()
                .name("junit添加测试")
                .build();
        try{
            mockMvc.perform(
                    MockMvcRequestBuilders.post("/job/addJob")
                            .accept("application/json;charset=utf-8")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content( new ObjectMapper().writeValueAsString(job))
            ).andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn().getResponse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete(){
        try{
            mockMvc.perform(
                    MockMvcRequestBuilders.delete("/job/deleteJobs")
                            .param("ids","4,5,6")
                            .accept("application/json;charset=utf-8")
                            .contentType(MediaType.APPLICATION_JSON)
                    //                         .content( new ObjectMapper().writeValueAsString(ids))
            ).andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn().getResponse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
