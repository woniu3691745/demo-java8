package com.concurrency.lesson02;

/**
 * 描述:
 *      线程组
 * @author lidongliang
 * @create 2017-11-02 13:46
 */
public class SimpleThreadGroup implements Runnable {

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("PrintGroup");
        Thread t1 = new Thread(threadGroup, new SimpleThreadGroup(), "T1");
        Thread t2 = new Thread(threadGroup, new SimpleThreadGroup(), "T2");
        t1.start();
        t2.start();
        System.out.println(threadGroup.activeCount());
        threadGroup.list();
    }

    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName()+ "-" + Thread.currentThread().getName();
        while (true) {
            System.out.println("I am " + groupAndName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
