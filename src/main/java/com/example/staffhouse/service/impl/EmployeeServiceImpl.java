package com.example.staffhouse.service.impl;

import com.example.staffhouse.Vo.PageObject;
import com.example.staffhouse.dao.EmployeeInfDao;
import com.example.staffhouse.entity.Employee;
import com.example.staffhouse.entity.EmployeeInf;
import com.example.staffhouse.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeInfDao employeeInfDao;
    @Override
    public PageObject<EmployeeInf> getEmployeeByLike(Integer deptId, Integer jobId, Integer sex, String name, String phone, Integer page, Integer limit) {
        if (page == 0 || limit == 0 || page < 0 || limit < 0) {
            return null;
        }
        page = page - 1;
        if (page > 1) {
            page = (page - 1) * limit;
        }
        List<EmployeeInf> employeeList = employeeInfDao.getEmployeeByLike(deptId, jobId, sex, name, phone, page, limit);
        Number total = employeeInfDao.countEmployeeByLike(deptId, jobId, sex, name, phone);
        return new PageObject<>(total.longValue(),employeeList);
    }

    @Override
    public Integer editEmployee(EmployeeInf employee) {
        return employeeInfDao.updateByPrimaryKeySelective(employee);
    }

    @Override
    public Integer addEmployee(EmployeeInf employee) {
        return employeeInfDao.insertSelective(employee);
    }
}
