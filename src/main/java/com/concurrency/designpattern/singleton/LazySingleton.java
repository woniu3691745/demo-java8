package com.concurrency.designpattern.singleton;

/**
 * 描述:
 * 懒加载的单例
 *
 * @author lidongliang
 * @create 2017-11-20 11:25
 */
public class LazySingleton {

    private LazySingleton() {
        System.out.println("LazySingleton is create");
    }

    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
