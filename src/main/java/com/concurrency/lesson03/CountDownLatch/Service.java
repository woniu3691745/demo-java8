package com.concurrency.lesson03.CountDownLatch;

public interface Service {

    boolean isStarted();

    void start();

    void stop();
}
