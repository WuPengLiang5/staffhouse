package com.example.staffhouse.service;

import com.example.staffhouse.Vo.PageObject;
import com.example.staffhouse.entity.EmployeeInf;

public interface EmployeeService {
    PageObject<EmployeeInf> getEmployeeByLike(Integer deptId, Integer jobId, Integer sex, String name, String phone, Integer page, Integer limit,String cardId);

    Integer editEmployee(EmployeeInf employee);

    Integer addEmployee(EmployeeInf employee);

    Integer deleteEmployee(Integer id);

    Integer deleteEmployees(String ids);
}

