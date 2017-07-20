package com.example.thread.threadPool;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by lidongliang on 2017/7/19.
 * newFixedThreadPool() 返回一个固定线程量的线程池。
 */
public class ExecutorsThreadPool {

    /**
     * 1、newFixedThreadPool
     * 2、newSingleThreadExecutor
     * 3、newCachedThreadPool
     */
    public static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thead ID:" + Thread.currentThread().getId());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ScheduledExecutorServiceTask implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(System.currentTimeMillis() / 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        MyTask myTask = new MyTask();

        // 固定线程数量的线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // 只有一个线程的线程池
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 根据实际情况调整线程数量的线程池
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < 10; i++) {
//            // 10个任务
//            executorService.submit(myTask);
//        }
//        executorService.shutdown();

        // 如果前面的任务没有完成，则调度也不会启动
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        // 创建一个定时任务
        scheduledExecutorService.schedule(new ScheduledExecutorServiceTask(), 0, TimeUnit.SECONDS);
        // 创建一个周期性任务
        scheduledExecutorService.scheduleAtFixedRate(new ScheduledExecutorServiceTask(), 0, 2, TimeUnit.SECONDS);
        // 创建并执行一个周期性任务
        scheduledExecutorService.scheduleWithFixedDelay(new ScheduledExecutorServiceTask(), 0, 2, TimeUnit.SECONDS);


        // 线程池工厂 ThreadFactory
        ExecutorService es = new ThreadPoolExecutor(
                5,
                5,
                0L,
                TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(),
                r -> {
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    System.out.println("create " + t);
                    return t;
                });

        for (int i = 0; i < 5; i++) {
            es.submit(myTask);
        }
        Thread.sleep(2000);
    }
}
