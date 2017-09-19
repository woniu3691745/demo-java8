package com.lidl.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by lidongliang on 2017/7/21.
 * <p>
 * ThreadLocal是一个线程的局部变量
 * 只是起到了简单的容器作用
 */
public class ThreadLocalDemo {

    private static final int GEN_COUNT = 10000000;
    private static final int THREAD_COUNT = 4;

    private static ExecutorService ex = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Random rnd = new Random(123);

    private static ThreadLocal<Random> tRnd = new ThreadLocal<Random>() {
        @Override
        protected Random initialValue() {
            return new Random(123);
        }
    };

    private static class RndTask implements Callable<Long> {

        private int modo = 0;

        private RndTask(int modo) {
            this.modo = modo;
        }

        private Random getRandom() {
            if (modo == 0) {
                return rnd;
            } else if (modo == 1) {
                return tRnd.get();
            } else {
                return null;
            }
        }

        @Override
        public Long call() throws Exception {

            long b = System.currentTimeMillis();
            for (long i = 0; i < GEN_COUNT; i++) {
                getRandom().nextInt();
            }
            long e = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " spend " + (e - b) + "ms");
            return e - b;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Long>[] futs = new Future[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            futs[i] = ex.submit(new RndTask(0));
        }
        long totaltime = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            totaltime += futs[i].get();
        }
        System.out.println("多线程访问同一个Random实例: " + totaltime + "ms");

        for (int i = 0; i < THREAD_COUNT; i++) {
            futs[i] = ex.submit(new RndTask(1));
        }
        totaltime = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            totaltime += futs[i].get();
        }
        System.out.println("使用ThreadLocal包装Random实例：" + totaltime + "ms");
        ex.shutdown();
    }
}
