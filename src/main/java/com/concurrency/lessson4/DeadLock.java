package com.concurrency.lessson4;

/**
 * 描述:
 * 死锁的线程不占用CPU
 *
 * @author lidongliang
 * @create 2017-11-10 16:36
 */
public class DeadLock extends Thread {

    private Object tool;
    private static final Object fork1 = new Object();
    private static final Object fork2 = new Object();

    private DeadLock(Object obj) {
        this.tool = obj;
        if (tool == fork1) {
            this.setName("哲学家A");
        }
        if (tool == fork2) {
            this.setName("哲学家B");
        }
    }

    @Override
    public void run() {
        if (tool == fork1) {
            synchronized (fork1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (fork2) {
                    System.out.println("哲学家A开始吃饭了");
                }
            }

        }
        if (tool == fork2) {
            synchronized (fork2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (fork1) {
                    System.out.println("哲学家B开始吃饭了");
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLock 哲学家A = new DeadLock(fork1);
        DeadLock 哲学家B = new DeadLock(fork2);

        哲学家A.start();
        哲学家B.start();
        Thread.sleep(1000);

//        String 李栋梁 = "ldl";
        
    }
}
