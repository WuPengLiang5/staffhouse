package com.example.staffhouse.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * employee_inf
 * @author 
 */
@Data
public class EmployeeInf implements Serializable {
    private Integer id;

    private Integer depId;

    private Integer jobId;

    private String name;

    private String cardId;

    private String address;

    private String postCode;

    private String tel;

    private String phone;

    private String qqNum;

    private String email;

    private Integer sex;

    private String party;

    private String birthday;

    private String pace;

    private String education;

    private String speciality;

    private String hobby;

    private String remark;

    private String createDate;

    private static final long serialVersionUID = 1L;
}