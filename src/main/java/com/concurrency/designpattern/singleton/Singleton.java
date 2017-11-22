package com.concurrency.designpattern.singleton;

/**
 * 描述:
 * 普通的单例
 *
 * @author lidongliang
 * @create 2017-11-20 10:27
 */
public class Singleton {

    private Singleton() {
        System.out.println("Singleton is create");
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

}
