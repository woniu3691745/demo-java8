package com.concurrency.lesson02;

/**
 * 描述:
 *      wait and notify show how use
 *
 *      Object.wait() 释放对象锁
 *      Thread.sleep() 不会释放任何资源
 *
 * @author lidongliang
 * @create 2017-11-01 16:44
 *
 */
public class SimpleWaitAndNotify {

    final static Object Object = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (Object) {
                System.out.println(System.currentTimeMillis()+":T1 start! ");
                try {
                    System.out.println(System.currentTimeMillis()+":T1 wait for object ");

                    Object.wait(); // 持有object对象锁，T1等待, 释放对象锁

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis()+":T1 end! ");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (Object) {
                System.out.println(System.currentTimeMillis()+":T2 start! notify one thread ");

                Object.notify(); // 获得object对象锁，通知T1，T1首先会尝试重新获得对象锁

                System.out.println(System.currentTimeMillis()+"T2 end! ");
                try {
                    Thread.sleep(2000); // 不释放对象锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}
