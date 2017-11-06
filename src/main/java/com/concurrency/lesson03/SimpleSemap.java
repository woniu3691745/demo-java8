package com.concurrency.lesson03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2017-11-02 16:37
 */
public class SimpleSemap implements Runnable {

    static Semaphore semp = new Semaphore(5);

    @Override
    public void run() {
        try {
            // 申请信号量
            semp.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ":done!");
            semp.release();
            // 释放信号量
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SimpleSemap demo = new SimpleSemap();
        for (int i = 0; i < 20; i++) {
            exec.submit(demo);
        }

        // 阿里建议
//        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(20,
//                new BasicThreadFactory.Builder().namingPattern("main").daemon(true).build());
//        for (int i = 0; i < 20; i++) {
//            executorService.submit(demo);
//        }

    }
}
