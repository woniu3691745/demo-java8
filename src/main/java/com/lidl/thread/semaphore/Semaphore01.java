package com.lidl.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by lidongliang on 2017/7/17.
 * Semaphore 信号量
 * 信号量可以指定多个线程，同时访问某一个资源
 */
public class Semaphore01 implements Runnable {

    private final Semaphore semp = new Semaphore(5);

    @Override
    public void run() {
        try {
            // 获得一个准入许可
            // 响应中断
            semp.acquire();

            // 不响应中断
//            semp.acquireUninterruptibly();

            // 尝试获得一个许可
//            semp.tryAcquire();

            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getId() + ":done!");
            // 释放许可
            semp.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // 创建20个线程的线程池
        ExecutorService exec = Executors.newFixedThreadPool(20);

        final Semaphore01 demo = new Semaphore01();
        for (int i = 0; i < 20; i++) {
            // 把Semaphore01的线程保存到线程
            exec.submit(demo);
        }

        // 关闭线程池
        exec.shutdown();
    }
}
