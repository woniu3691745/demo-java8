package com.example.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lidongliang on 2017/7/10.
 *
 */
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("");
        for (String i : list) {
            System.out.println(i);
        }
    }
}
