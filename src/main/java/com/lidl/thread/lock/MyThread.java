package com.lidl.thread.lock;

class MyThread extends Thread {

    private LockInterruptibly lockInterruptibly = null;

    MyThread(LockInterruptibly lockInterruptibly) {
        this.lockInterruptibly = lockInterruptibly;
    }

    @Override
    public void run() {

        try {
            lockInterruptibly.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"被中断");
        }
    }
}