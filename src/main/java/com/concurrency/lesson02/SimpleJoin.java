package com.concurrency.lesson02;

/**
 * 描述:
 *      join() 等待上一个线程完成后在运行
 *      Thread.yield() 它会使当前线程让出CPU，但不代表当前线程不执行了。
 *
 * @author lidongliang
 * @create 2017-11-02 10:32
 */
public class SimpleJoin {

    volatile static int i = 0;

    public static class AddThread extends Thread {
        @Override
        public void run() {
            i = 0;
            while (i < 1000000) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread at = new AddThread();
        at.start();
        at.join(); // 等待线程完成，释放cup
        System.out.println(i);
    }
}
