package com.concurrency.lesson02;

/**
 * 描述:
 *      volatile i++
 *
 * @author lidongliang
 * @create 2017-11-02 14:06
 */
public class SimplAccountingVol implements Runnable {

    /**
     * 指定加锁对象：对给定对象加锁，进入同步代码前要获得给定对象的锁
     */
    static SimplAccountingVol instance = new SimplAccountingVol();

//    private static int i = 0;

    private static volatile int i = 0;

//    private static void increase() {
//        i++;
//    }

    /**
     * 直接作用于实例方法：相当于对当前实例加锁，进入同步代码块前要获得当前实例的锁。
     */
//    private synchronized void increase() {
//        i++;
//    }

    /**
     * 直接作用于静态方法：相当于对当前类加锁，进入同步代码块前要获得当前类的锁。
     */
    private synchronized static void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(instance);
//        Thread t2 = new Thread(instance);
        Thread t1 = new Thread(new SimplAccountingVol());
        Thread t2 = new Thread(new SimplAccountingVol());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
