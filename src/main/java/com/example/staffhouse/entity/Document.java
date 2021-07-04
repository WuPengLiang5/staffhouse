package com.example.staffhouse.entity;

public class Document {
    private Integer id;
    private Integer userId;
    private String title;
    private String fileName;
    private String remark;
    private String createDate;

    public Document() {
    }

    public Document(Integer id, Integer userId, String title, String fileName, String remark, String createDate) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.fileName = fileName;
        this.remark = remark;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
