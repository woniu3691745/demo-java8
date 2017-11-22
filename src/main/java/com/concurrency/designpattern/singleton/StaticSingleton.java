package com.concurrency.designpattern.singleton;

/**
 * 描述:
 * 二合一
 *
 * @author lidongliang
 * @create 2017-11-20 11:30
 */
public class StaticSingleton {

    private StaticSingleton() {
        System.out.println("StaticSingleton is create");
    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
