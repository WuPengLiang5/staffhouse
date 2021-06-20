package com.example.staffhouse.controller;

import com.example.staffhouse.entity.Department;
import com.example.staffhouse.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/listDepartment")
    public List<Department> listDepartment(){
        return departmentService.listDepartment();
    }

    @RequestMapping("/saveDepartment")
    public void saveDepartment(Department department){
        departmentService.saveDepartment(department);
    }

    @RequestMapping("/deleteDepartment")
    public void deleteDepartment(Integer departmentId){
        departmentService.deleteDepartment(departmentId);
    }

    @RequestMapping("/updateDepartment")
    public void updateDepartment(Department department){
        departmentService.updateDepartment(department);
    }

    @RequestMapping("/getDepartmentById")
    public Department getDepartmentById(Integer departmentId){
        return departmentService.getDepartmentById(departmentId);
    }
}
