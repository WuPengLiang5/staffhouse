package com.example.staffhouse.dao;

import com.example.staffhouse.entity.EmployeeInf;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeInfDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeInf record);

    int insertSelective(EmployeeInf record);

    EmployeeInf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeInf record);

    int updateByPrimaryKey(EmployeeInf record);

    List<EmployeeInf> getEmployeeByLike(@Param("deptId") Integer deptId, @Param("jobId") Integer jobId, @Param("sex") Integer sex, @Param("name") String name, @Param("phone") String phone, @Param("page") Integer page, @Param("limit") Integer limit);

    Number countEmployeeByLike(Integer deptId, Integer jobId, Integer sex, String name, String phone);
}

