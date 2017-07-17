package com.example.thread.countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lidongliang on 2017/7/17.
 * countDownLatch 是一个非常实用的多线程控制工具类
 */
public class CountDownLatch01 implements Runnable {

    // 计数10个
    private static final CountDownLatch end = new CountDownLatch(10);
    private static final CountDownLatch01 demo = new CountDownLatch01();

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("Check complete");

            // 1个线程完成了，减少1个
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // 创建10个线程的线程池
        ExecutorService exec = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            // 把CountDownLatch01的线程保存到线程
            exec.submit(demo);
        }

        // 等待全部线程完成
        end.await();

        System.out.println("Fire");

        // 关闭线程池
        exec.shutdown();

    }
}
