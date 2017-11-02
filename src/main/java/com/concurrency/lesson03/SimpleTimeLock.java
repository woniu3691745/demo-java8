package com.concurrency.lesson03;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 *
 * public boolean tryLock()
 * 等待，若超时直接返回false
 *
 * public boolean tryLock(long timeout, TimeUnit unit)
 * 不会进行等待，直接返回false
 *
 * @author lidongliang
 * @create 2017-11-02 15:09
 */
public class SimpleTimeLock implements Runnable {

    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                Thread.sleep(6000);
                System.out.println(Thread.currentThread().getName());
            } else {
                System.out.println(Thread.currentThread().getName());
                System.out.println("get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        SimpleTimeLock tl = new SimpleTimeLock();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);
        t1.start();
        t2.start();
    }
}
