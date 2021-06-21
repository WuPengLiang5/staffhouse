package com.example.staffhouse.entity;

public class NoticeDTO extends Notice {

    private String userName;

    public NoticeDTO(Integer id, Integer userId, String title, String content, String createDate) {
        super(id, userId, title, content, createDate);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
