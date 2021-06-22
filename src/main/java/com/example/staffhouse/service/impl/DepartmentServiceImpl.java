package com.example.staffhouse.service.impl;

import com.example.staffhouse.dao.DepartmentDao;
import com.example.staffhouse.entity.Department;
import com.example.staffhouse.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> listDepartment() {
        return departmentDao.listDepartment();
    }

    @Override
    public List<Department> listDepartmentByName(String name) {
        return departmentDao.listDepartmentByName(name);
    }

    @Override
    public void saveDepartment(Department department) {
        departmentDao.saveDepartment(department);
    }

    @Override
    public void deleteDepartment(Integer departmentId) {
        departmentDao.deleteDepartment(departmentId);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentDao.updateDepartment(department);
    }

    @Override
    public Department getDepartmentById(Integer departmentId) {
        return departmentDao.getDepartmentById(departmentId);
    }
}
