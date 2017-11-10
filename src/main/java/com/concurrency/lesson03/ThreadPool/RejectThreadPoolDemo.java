package com.concurrency.lesson03.ThreadPool;

import java.util.concurrent.*;

/**
 * 描述:
 * 自定义线程池和拒绝策略
 *
 * @author lidongliang
 * @create 2017-11-07 10:05
 */
public class RejectThreadPoolDemo {

    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        // 自定义拒绝策略
        ExecutorService es = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString() + "is discard");
                    }
                });

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            es.submit(task);
            Thread.sleep(10);
        }
    }

}
