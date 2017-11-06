package com.concurrency.lesson03;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 描述:
 * 可以反复使用
 * <p>
 * 注意
 * InterruptedException
 * 和
 * BrokenBarrierException
 *
 * @author lidongliang
 * @create 2017-11-06 14:54
 */
public class SimpleCyclicBarrier {

    public static class Soldier implements Runnable {

        private String soldierName;
        private final CyclicBarrier cyclic;

        private Soldier(CyclicBarrier cyclic, String soldierName) {
            this.cyclic = cyclic;
            this.soldierName = soldierName;
        }

        @Override
        public void run() {
            try {
                // 等到计数10后，执行run()方法
                // 等待所有士兵到齐
                cyclic.await();

                // 依次执行10个线程
                doWork();

                // 等到计数10后，执行run()方法
                // 等待所有士兵完成工作
                cyclic.await();        // ---> 此次体现CyclicBarrier的await()方法后，再一次自动计数

            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldierName + ": 任务完成");
        }
    }

    public static class BarrierRun implements Runnable {

        boolean flag;
        int N;

        private BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("司令：[士兵 " + N + " 个，任务完成！]");
            } else {
                System.out.println("司令：[士兵 " + N + " 个，集合完毕！]");
                flag = true;
            }
        }
    }

    public static void main(String[] args) {

        final int N = 10;
        Thread[] allSoldier = new Thread[N];

        // 创建10个计数，保存到CyclicBarrier计数器
        CyclicBarrier cyclic = new CyclicBarrier(N, new SimpleCyclicBarrier.BarrierRun(false, N));

        // 设置屏障点，主要是为了执行这个方法
        System.out.println("集合队伍！");
        for (int i = 0; i < N; i++) {
            System.out.println("士兵 " + i + " 报道！");
            // 创建10个线程，依次启动
            allSoldier[i] = new Thread(new SimpleCyclicBarrier.Soldier(cyclic, "士兵 " + i));
            allSoldier[i].start();
        }
    }

}
