package com.example.staffhouse.entity;

/**
 * @author NIIT
 */
public class UserLoginDTO {
    private Integer id;
    private String loginName;
    private String userName;
    private Integer status;
    private String token;

    public UserLoginDTO() {
    }

    public UserLoginDTO(Integer id, String loginName,String userName, Integer status) {
        this.id = id;
        this.loginName = loginName;
        this.userName = userName;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
