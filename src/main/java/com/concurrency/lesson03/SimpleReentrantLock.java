package com.concurrency.lesson03;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 * <p>
 * ReentrantLock 重入锁
 *
 * @author lidongliang
 * @create 2017-11-02 14:44
 */
public class SimpleReentrantLock implements Runnable {

    private static ReentrantLock lock = new ReentrantLock();

    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleReentrantLock tl = new SimpleReentrantLock();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
