package com.concurrency.lesson02;

/**
 * 描述:
 *      volatile
 *          i++ 无法保证原子性
 *          64位 long 无法保证原子性
 * @author lidongliang
 * @create 2017-11-02 10:56
 */
public class SimpleVolatile {

    private static boolean ready;
    private static int number;

//    private volatile static boolean ready;
//    private volatile static int number;

    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            while (!ready) {
                System.out.println(number);
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        new ReaderThread().start();
        // 不会释放锁，一直运行run，睡觉结束后改变ready，退出线程
        Thread.sleep(1000);
        System.out.println("start sleep");
        number = 42;
        ready = true;
        System.out.println("end sleep");
        Thread.sleep(10000);
    }
}
