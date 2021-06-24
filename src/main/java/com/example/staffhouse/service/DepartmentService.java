package com.example.staffhouse.service;

import com.example.staffhouse.entity.Department;

import java.util.List;

public interface DepartmentService {
    /**
     * 部门查询
     * @return
     */
    public List<Department> listDepartment();

    public List<Department> listDepartmentByName(String name);

    public void saveDepartment(Department department);

    public void deleteDepartment(Integer departmentId);

    public void updateDepartment(Department department);

    public Department getDepartmentById(Integer departmentId);

}
