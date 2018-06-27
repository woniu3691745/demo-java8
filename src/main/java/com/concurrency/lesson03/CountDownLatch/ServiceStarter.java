package com.concurrency.lesson03.CountDownLatch;

public class ServiceStarter {

    public static void main(String[] args) {

        ServiceManager.startServices();

        boolean allIsOK;
        allIsOK = ServiceManager.checkServiceStatus();

        if (allIsOK) {
            System.out.println("all start");
        } else {
            System.out.println("error");
            System.exit(1);
        }
    }
}
