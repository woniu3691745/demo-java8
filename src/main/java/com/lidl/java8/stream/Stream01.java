package com.lidl.java8.stream;

import com.lidl.entity.UserInfo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by lidongliang on 2017/7/11.
 * collect -> 惰性操作
 * reduce -> 及早求值
 * 1：collect
 * 2：map
 * 3: filter
 * 4: flatMap
 * 5: max、min
 * 6：reduce
 */
public class Stream01 {

    /**
     * collect
     * 及早求值方法
     * 1：生成Stream
     * 2：在Stream上一系列操作
     * 3：执行collect
     */
    private void collect() {
        List<String> collect = Stream.of("a", "b", "c").collect(Collectors.toList());
        assertEquals(asList("a", "b", "c"), collect);
    }

    /**
     * map
     * 1：一个函数可以将一种类型的值转换成另外一种类型
     * 2：一个流中的值转换成一个新的流
     * 3：old Stream -> new Stream
     * 4：任何时候想转化或替代代码，都应该使用map操作
     */
    private void map() {
        List<String> collect = Stream.of("a", "b", "hello")
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        assertEquals(asList("A", "B", "HELLO"), collect);
    }

    /**
     * filter
     * 1：遍历数据并检查其中的元素时
     */
    private void filter() {
        List<String> beginningWithNumbers = Stream.of("d", "1abc", "a2bc1")
                .filter(s -> isDigit(s.charAt(0)))
                .collect(Collectors.toList());
        assertEquals(asList("1abc"), beginningWithNumbers);
    }

    /**
     * flatMap
     * 1：可用Stream替换值，然后将多个Stream连接成一个Stream
     * 2：把多个Stream合并成一个Stream并返回
     */
    private void flatMap() {
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());
        assertEquals(asList(1, 2, 3, 4), together);
    }

    /**
     * max、min
     * 1：Stream上常用的操作之一是求最大值和最小值
     */
    private void minAndMax() {
        List<UserInfo> userInfos = asList(new UserInfo("lidongliang", 27, 1, true),
                new UserInfo("liyongxuan", 26, 0, true),
                new UserInfo("lixiaoming", 29, 1, true));
        UserInfo userInfo1 = userInfos.stream()
//                .min(Comparator.comparing(userInfo -> userInfo.getAge()))
                .max(Comparator.comparing(userInfo -> userInfo.getAge()))
                .get();
        System.out.println(userInfo1);
        assertEquals(userInfos.get(2), userInfo1);
    }

    /**
     * reduce
     * 1：可以实现从一组值中生成一个值
     * 2：count，min，max -> reduce
     */
    private void reduce() {
        int count = Stream.of(1, 2, 3)
                .reduce(0, (acc, element) -> acc + element);
        assertEquals(6, count);
    }

    public static void main(String[] args) {
        Stream01 stream01 = new Stream01();
//        stream01.collect();
//        stream01.map();
//        stream01.filter();
//        stream01.flatMap();
//        stream01.minAndMax();
        stream01.reduce();
    }
}
