package com.utils;

import java.util.stream.IntStream;

/**
 * 描述: 随机数
 *
 * @author lidongliang
 * @create 2017-12-26 15:12
 */
public class Random {

    public static void main(String[] args) {
        java.util.Random random = new java.util.Random();
        IntStream intStream = random.ints(0, 100);
        intStream.limit(10).forEach(System.out::println);
    }
}
