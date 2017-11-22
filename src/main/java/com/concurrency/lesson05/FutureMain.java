package com.concurrency.lesson05;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 描述:
 * future.get()得到实际的数据
 *
 * @author lidongliang
 * @create 2017-11-22 14:00
 */
public class FutureMain {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // 构造FutureTask
        FutureTask<String> future = new FutureTask<>(new RealData("a"));

        ExecutorService executor = Executors.newFixedThreadPool(1);

        // 在这里开启线程进行RealData的call()执行
        executor.submit(future);
        System.out.println(future);

        System.out.println("请求完毕");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据 " + future.get());
    }

}
