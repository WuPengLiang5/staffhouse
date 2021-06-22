package com.example.staffhouse.controller;

import com.example.staffhouse.entity.Department;
import com.fasterxml.jackson.core.JsonProcessingException;
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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DepartmentControllerTest {
    @Autowired
    public DepartmentController departmentController;

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

    /**
     * 查询方法
     */
    @Test
    public void listDepartment(){
        System.out.println("list......");
        try{
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/department/listDepartment")
                    .accept("application/json;charset=utf-8"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 删除方法
     */
    @Test
    public void delete(){
        System.out.println("delete......");
        try{
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/department/deleteDepartment")
                            .accept("application/json;charset=utf-8")
                            .param("departmentId","126"))
                            .andExpect(MockMvcResultMatchers.status().is(200))
                            .andDo(MockMvcResultHandlers.print()).andReturn();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 保存部门
     */
    @Test
    public void save() throws JsonProcessingException {
        System.out.println("save......");
        Department department = new Department(null,"哈哈部","哈哈部");
        //设置值
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(department);
        try{
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.post("/department/saveDepartment")
                            .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            System.out.println(mvcResult);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 修改部门
     */
    @Test
    public void update() throws JsonProcessingException {
        System.out.println("update......");
        Department department = new Department(2,"财务部","财务部");
        //设置值
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(department);
        try{
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.post("/department/updateDepartment")
                            .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            System.out.println(mvcResult);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}