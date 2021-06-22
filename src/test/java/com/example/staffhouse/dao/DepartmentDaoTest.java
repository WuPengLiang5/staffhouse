package com.example.staffhouse.dao;


import com.example.staffhouse.entity.Department;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DepartmentDaoTest {

    @Autowired
    DepartmentDao departmentDao;

    @Before
    public void beforeTest(){
        System.out.println("Before test.....");
    }

    @Test
    public void listDepartment(){
        System.out.println("listDepartment test start....");
        departmentDao.listDepartment();
    }

    @Test
    public void listDepartmentByName(){
        System.out.println("listDepartmentByName test start....");
        departmentDao.listDepartmentByName("123");
    }

    @Test
    public void saveDepartment(){
        System.out.println("saveDepartment test start....");
        Department department = new Department(126,"静静静", "笑哈哈");
        departmentDao.saveDepartment(department);
    }

    @Test
    public void getNoticeById(){
        System.out.println("getDepartmentById test start....");
        Department department = departmentDao.getDepartmentById(123);
        System.out.println(department.getId());
        System.out.println(department.getName());
        System.out.println(department.getRemark());
    }

    @Test
    public void updateNotice(){
        System.out.println("updateNotice test start....");
        Department department = new Department(125,"静静静", "笑哈哈");
        departmentDao.updateDepartment(department);
    }

    @Test
    public void deleteNotice(){
        System.out.println("deleteNotice test start....");
        departmentDao.deleteDepartment(123);
    }
}
