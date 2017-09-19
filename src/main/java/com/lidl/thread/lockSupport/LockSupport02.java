package com.lidl.thread.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by lidongliang on 2017/7/17.
 * LockSupport.park() 不会抛出InterruptException，只会默认返回
 */
public class LockSupport02 {

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
                LockSupport.park();
                if (Thread.interrupted()) { // 获得中断标记
                    System.out.println(getName() + "被中断了");
                }
                System.out.println(getName() + "执行结束");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.interrupt();
        LockSupport.unpark(t2);
    }
}
