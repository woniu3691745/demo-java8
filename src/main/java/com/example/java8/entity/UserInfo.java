package com.example.java8.entity;

/**
 * Created by lidongliang on 2017/7/10.
 * 实体
 */
public class UserInfo {

    private String userName;
    private int age;
    private int sex;

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

    public UserInfo(String userName, int age, int sex) {
        this.userName = userName;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
