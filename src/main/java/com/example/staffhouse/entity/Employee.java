package com.example.staffhouse.entity;

public class Employee {
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

    public Employee() {
    }

    public Employee(Integer id, Integer depId, Integer jobId, String name, String cardId, String address, String postCode, String tel, String phone, String qqNum, String email, Integer sex, String party, String birthday, String pace, String education, String speciality, String hobby, String remark, String createDate) {
        this.id = id;
        this.depId = depId;
        this.jobId = jobId;
        this.name = name;
        this.cardId = cardId;
        this.address = address;
        this.postCode = postCode;
        this.tel = tel;
        this.phone = phone;
        this.qqNum = qqNum;
        this.email = email;
        this.sex = sex;
        this.party = party;
        this.birthday = birthday;
        this.pace = pace;
        this.education = education;
        this.speciality = speciality;
        this.hobby = hobby;
        this.remark = remark;
        this.createDate = createDate;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPace() {
        return pace;
    }

    public void setPace(String pace) {
        this.pace = pace;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
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
