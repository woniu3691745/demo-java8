package com.concurrency.lesson03;

import sun.awt.windows.ThemeReader;

import javax.crypto.interfaces.PBEKey;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2017-11-06 15:12
 */
public class SimpleLockSupport {

    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {

        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                LockSupport.park();
            }
        }


//        @Override
//        public void run() {
//            synchronized (u) {
//                System.out.println("in " + getName());
//                LockSupport.park();
//                if (Thread.interrupted()) {
//                    System.out.println(getName() + "被中断了");
//                }
//            }
//            System.out.println(getName() + "执行结束");
//        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(1000);
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();


//        t1.start();
//        Thread.sleep(1000);
//        t2.start();
//        t1.interrupt();
//        LockSupport.unpark(t2);
    }
}
