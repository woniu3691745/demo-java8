package com.guava;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import java.util.List;

/**
 * Guava学习
 *
 * @author lidongliang
 * @create 2017-12-25 下午9:54
 **/
public class GuavaDemo {

    private static void listTest() {
        List<Integer> intList = Ints.asList(1, 2, 3, 4, 5);
        List<Integer> reverseList = Lists.reverse(intList);
        System.out.println(reverseList.toString());
    }

    public static void main(String[] args) {
        GuavaDemo.listTest();
    }

}
