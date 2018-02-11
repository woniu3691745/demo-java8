package com.concurrency.lesson03.CountDownLatch;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class ServiceManager {

    static volatile CountDownLatch latch;
    static Set<Service> services;

    public static void startServices() {
        services = getServices();
        for (Service service : services) {
            service.start();
        }
    }

    public static boolean checkServiceStatus() {
        boolean allIsOK = true;
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        for (Service service : services) {

            if (!service.isStarted()) {
                allIsOK = false;
                break;
            }
        }
        return allIsOK;
    }

    private static Set<Service> getServices() {
        latch = new CountDownLatch(1);
        HashSet<Service> services = new HashSet<>();
        services.add(new AbstractServiceImpl(latch));
        services.add(new AbstractServiceImpl1(latch));
        return services;
    }
}
