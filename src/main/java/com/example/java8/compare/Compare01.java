package com.example.java8.compare;

import com.example.java8.entity.UserInfo;
import org.assertj.core.util.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lidongliang on 2017/7/10.
 * 排序
 */
public class Compare01 implements Comparator<String> {

    private static final List<UserInfo> userInfos;

    static {
        userInfos = Lists.newArrayList(new UserInfo("lidongliang", 27, 1, true),
                new UserInfo("liyongxuan",26, 0, true),
                new UserInfo("Tony", 30, 0, true));
    }

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }

    /**
     * JDK8 -
     * 基本排序
     */
    public void c1() {
        String[] s1 = {"12", "22", "4", "421", "2"};
        Arrays.sort(s1, new Compare01());
        for (String i : s1) {
            System.out.println("s1 = " + i);
        }
    }

    /**
     * JDK8 -
     * 基本排序
     */
    public void c0() {
        // 字符串用compareTo
        new Comparator<UserInfo>() {
            @Override
            public int compare(UserInfo h1, UserInfo h2) {
                return h1.getUserName().compareTo(h2.getUserName());
            }
        };
        // 整数用 ' + , - '
        Collections.sort(userInfos, new Comparator<UserInfo>() {
            @Override
            public int compare(UserInfo h1, UserInfo h2) {
                return h2.getAge() - h1.getAge();
            }
        });
        for (UserInfo userInfo : userInfos) {
            System.out.println("userInfo = " + userInfo);
        }
    }

    /**
     * JDK8
     * 方法引用
     */
    public void c2() {
        String[] s2 = {"1", "22", "433", "3", "11"};
        Arrays.sort(s2, Comparator.comparingInt(String::length));
        for (String i : s2) {
            System.out.println("s2 = " + i);
        }
    }

    /**
     * JDK8
     * 方法引用，多条件组合排序
     */
    public void c3() {
        userInfos.sort(Comparator.comparing(UserInfo::getAge).thenComparing(UserInfo::getSex));
        for (UserInfo userInfo : userInfos) {
            System.out.println("userInfo = " + userInfo);
        }
    }

    /**
     * JDK8
     * lambda
     */
    private void c4() {
//        userInfos.sort((UserInfo h1, UserInfo h2) -> h1.getUserName().compareTo(h2.getUserName()));
//        userInfos.sort((h1, h2) -> h1.getUserName().compareTo(h2.getUserName()));
        userInfos.sort((lhs, rhs) -> {
            if (lhs.getUserName().equals(rhs.getUserName())) {
                return lhs.getAge() - rhs.getAge();
            } else {
                return lhs.getUserName().compareTo(rhs.getUserName());
            }
        });

        for (UserInfo userInfo : userInfos) {
            System.out.println("userInfo = " + userInfo);
        }
    }

    public static void main(String[] args) {

        Compare01 compare01 = new Compare01();
        compare01.c4();
    }
}
