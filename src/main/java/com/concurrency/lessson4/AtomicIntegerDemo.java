package com.concurrency.lessson4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:
 * <p>
 * 无锁的线程安全整数
 *
 * @author lidongliang
 * @create 2017-11-10 15:48
 */
public class AtomicIntegerDemo {

    static AtomicInteger i = new AtomicInteger();

    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int j = 0; j < 1000; j++) {
                i.incrementAndGet();    // 加1
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for (int j = 0; j < 10; j++) {
            ts[j] = new Thread(new AddThread());
        }
        for (int k = 0; k < 10; k++) {
            ts[k].start();
        }
        for (int k = 0; k < 10; k++) {
            ts[k].join();
        }
        System.out.println(i);
    }
}
