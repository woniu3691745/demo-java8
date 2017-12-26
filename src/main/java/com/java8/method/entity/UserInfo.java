package com.java8.method.entity;

/**
 * Created by lidongliang on 2017/7/10.
 * 实体
 */
public class UserInfo {

    private String userName;
    private int age;
    private int sex;
    private Boolean isHeight;

    public UserInfo() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Boolean getHeight() {
        return isHeight;
    }

    public void setHeight(Boolean height) {
        isHeight = height;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", isHeight=" + isHeight +
                '}';
    }

    public UserInfo(String userName, int age, int sex, Boolean isHeight) {
        this.userName = userName;
        this.age = age;
        this.sex = sex;
        this.isHeight = isHeight;
    }
}
