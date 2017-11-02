package com.concurrency.lesson03;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 * new ReentrantLock(true) 公平锁
 *
 * @author lidongliang
 * @create 2017-11-02 15:50
 */
public class SimpleFairLock implements Runnable {

    /**
     * true：公平锁
     */
    private static ReentrantLock fairLock = new ReentrantLock(true);


    @Override
    public void run() {
        while (true) {
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + " 获得锁");
            } finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        SimpleFairLock r1 = new SimpleFairLock();
        Thread t1 = new Thread(r1, "Thread_t1");
        Thread t2 = new Thread(r1, "Thread_t2");
        t1.start();
        t2.start();
    }
}
