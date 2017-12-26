package com.java8.method.concurrent;

import com.java8.method.entity.UserInfo;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by lidongliang on 2017/7/12.
 * 并发和并行是两个不同的概念，它们的作用也不一样。
 */
public class Concurrent {

    /**
     * 并发是两个任务 共享 时间段，并行则是两个任务在 同一时间 发生。
     * 例如：运行在多核CPU上，一个程序要运行两个任务，并且只有一个CPU给它们分配了不同的时间片，那么这就是并发。
     *
     * 例如：并行化是指为缩短任务执行时间，将一个任务分解成几部分，然后并行执行。
     *
     */

    /**
     * 影响并行流的主要因素有五个
     * 1：数据大小
     *      -> 输入数据的大小会影响并行化处理对性能的提升
     * 2：源数据结构
     *      -> 每个管道的操作都基于一些初始数据源，通常是集合
     * 3：装箱
     *      -> 处理基本类型比处理装箱类型要快
     * 4：核的数量
     *      -> 极端情况下，只有一个核，因此完全没必要并行化。
     *         显然，拥有的核越多，获得潜在性能提升的幅度就越大
     * 5：单元处理开销
     *      -> 比如数据大小，这是一场并行执行花费时间和分解合并操作开销之间的战争。
     *         花在流中每个元素身上的时间越长，并行操作带来的性能提升越明显。
     *
     * 在底层，并行流还是沿用了fork/join 框架。
     * fork 递归式地分解问题，然后每段并行执行，最终由join 合并结果，返回最后的值。
     *
     * 如果能避开有状态，选用无状态操作，就能获得更好的并行性能。
     *  -> 无状态操作包括map、filter 和flatMap
     *  -> 有状态操作包括sorted、distinct 和limit
     */

    /**
     * parallelStream
     * 哪种方式花的时间更多取决于串行或并行化运行时的环境
     *
     * @param userInfoList 实体
     */
    private void serialArrayNum(List<UserInfo> userInfoList) {
        long count = userInfoList
                .parallelStream()
//                .flatMap(UserInfo::getUserName)
                .mapToInt(UserInfo::getAge)
                .count();
        System.out.println(count);
    }


    public static void main(String[] args) {
        List<UserInfo> userInfos = asList(new UserInfo("lidongliang", 27, 1, true),
                new UserInfo("liyongxuan", 26, 0, true),
                new UserInfo("lixiaoming", 29, 1, false),
                new UserInfo("lixiaoming", 29, 2, false),
                new UserInfo("liyongxuan", 29, 1, false));
        Concurrent concurrent = new Concurrent();

        concurrent.serialArrayNum(userInfos);
    }
}
