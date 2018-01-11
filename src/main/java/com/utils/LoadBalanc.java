package com.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Random;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2018-01-11 10:36
 */
public class LoadBalanc {

    private static List<String> list = Arrays.asList("198.168.0.1", "198.168.0.2", "198.168.0.3");
    private static int pos = 0;
    private static final Object LOCK = new Object();

    /**
     * 轮训法
     *
     * @return ip
     */
    private static String getConnectionAddressRobin() {
        String ip;
        synchronized (LOCK) {
            ip = list.get(pos);
            if (++pos >= list.size()) {
                pos = 0;
            }
        }
        return ip;
    }

    /**
     * 随机法
     *
     * @return ip
     */
    private static String getConnectionAddressRandom() {
        Random random = new Random();
        int pos = random.nextInt(list.size());
        return list.get(pos);
    }


    /**
     * 源地址哈希法
     *
     * @return ip
     * @throws UnknownHostException 异常
     */
    private static String getConnectionAddressHash() throws UnknownHostException {

        int ipHashCode = InetAddress.getLocalHost().getHostAddress().hashCode();

        int pos = ipHashCode % list.size();

        return list.get(pos);
    }

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
//                String address = getConnectionAddressRobin();
//                String address = getConnectionAddressRandom();
                String address = null;
                try {
                    address = getConnectionAddressHash();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                System.out.println(address);
            }
        }, 1, 2, TimeUnit.SECONDS);


//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 35; i++) {
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//                    String address = getConnectionAddress();
//                    System.out.println(address);
//                    System.out.println(Thread.currentThread().getName());
//                }
//            });
//        }
//        executorService.shutdown();
    }
}
