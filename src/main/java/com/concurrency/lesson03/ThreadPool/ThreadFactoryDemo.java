package com.concurrency.lesson03.ThreadPool;

import java.util.concurrent.*;

/**
 * 描述:
 * 自定义线程创建
 * <p>
 * 使用自定义线程池可以让我们更加自由地设置池子中所有线程的状态
 *
 * @author lidongliang
 * @create 2017-11-07 10:14
 */
public class ThreadFactoryDemo {

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
        com.concurrency.lesson03.ThreadPool.RejectThreadPoolDemo.MyTask task = new com.concurrency.lesson03.ThreadPool.RejectThreadPoolDemo.MyTask();
        // 自定义拒绝策略
        ExecutorService es = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread();
                        t.setDaemon(true);
                        System.out.println("create t");
                        return t;
                    }
                },
                new ThreadPoolExecutor.DiscardPolicy()
        );


        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            es.submit(task);
            Thread.sleep(10);
        }
    }
}
