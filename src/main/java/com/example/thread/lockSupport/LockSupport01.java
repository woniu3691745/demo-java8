package com.example.thread.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by lidongliang on 2017/7/17.
 * LockSupport 是一个非常实用的线程阻塞工具
 * LockSupport 使用类似信号量机制
 * <p>
 * 即使unpark()操作发生在park()之前，它也可以使下一次的park()操作立即返回
 */
public class LockSupport01 {

    private static final Object u = new Object();
    private static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    private static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {

        private ChangeObjectThread(String name) {
            super.setName(name);
        }

        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                LockSupport.park(); // 等待
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        LockSupport.unpark(t1); // 释放
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}
