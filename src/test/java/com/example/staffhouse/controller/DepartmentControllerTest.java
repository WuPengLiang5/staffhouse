package com.example.staffhouse.controller;

import com.example.staffhouse.entity.Department;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
    public void save(){
        System.out.println("save......");
        try{
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/department/saveDepartment")
                            .accept("application/json;charset=utf-8")
                            .param("id","126")
                            .param("name","技术部")
                            .param("remark","技术部"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 修改部门
     */
    @Test
    public void update(){
        System.out.println("update......");
        try{
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/department/updateDepartment")
                            .accept("application/json;charset=utf-8")
                            .param("id","126")
                            .param("name","财务部")
                            .param("remark","财务部"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}