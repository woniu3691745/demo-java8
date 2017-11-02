package com.concurrency.lesson03;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 * ReentrantLock
 * Condition
 * <p>
 * ArrayBlockingQueue
 *
 * @author lidongliang
 * @create 2017-11-02 16:10
 */
public class SimpleReenterLockCondition implements Runnable {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println("Thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleReenterLockCondition tl = new SimpleReenterLockCondition();
        Thread t1 = new Thread(tl);
        t1.start();
        Thread.sleep(2000);
        // 通知线程t1继续执行
        // 重新尝试获得与之绑定的重入锁
        lock.lock();
        condition.signal();// 需要获得相关的锁
        lock.unlock();


        // 无法重新获得锁，也就无法真正的继续执行
//        lock.unlock();
    }
}
