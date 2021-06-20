package com.example.staffhouse.dao;

import com.example.staffhouse.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value="DapartmentDao")
public interface DepartmentDao {
    List<Department> listDepartment();

    void saveDepartment(Department department);

    void deleteDepartment(Integer departmentId);

    void updateDepartment(Department department);

    Department getDepartmentById(Integer departmentId);
}
