package com.example.administrator.lvschool;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2017/2/6.
 */

public class Users extends BmobUser {
    private String name;
    private String school;
    private String sex;
    private String address;
    private String academy;
    private String mobilePhoneNumber;
    private String email;
    private String myclass;
    private String password;
    private String user_name;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setMyclass(String myclass) {
        this.myclass = myclass;
    }

    public String getMyclass() {
        return myclass;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getAcademy() {
        return academy;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
