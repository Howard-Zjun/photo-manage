package pers.howard.personalspace.model;

import java.util.Date;

/**
 * 个人资料模型
 */
public class PersonDataItem {
    private String userID;// 唯一码
    private String name;
    private boolean sex;
    private String address;
    private Date birth;
    private String phone;
    private String email;
    private String introduction;

    public PersonDataItem(String userID, String name, boolean sex, String address, Date birth, String phone, String email, String introduction) {
        this.userID = userID;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.birth = birth;
        this.phone = phone;
        this.email = email;
        this.introduction = introduction;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
