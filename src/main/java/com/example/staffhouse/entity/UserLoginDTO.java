package com.example.staffhouse.entity;

/**
 * @author NIIT
 */
public class UserLoginDTO {
    private Integer id;
    private String loginName;
    private Integer status;

    public UserLoginDTO() {
    }

    public UserLoginDTO(Integer id, String loginName, Integer status) {
        this.id = id;
        this.loginName = loginName;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
