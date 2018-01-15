package com.utils.currentlimit;

/**
 * ${DESCRIPTION}
 *
 * @author lidongliang
 * @create 2018-01-15 下午9:30
 **/
public class Task3 implements Runnable {
    String str;

    public Task3(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        System.out.println("Task2 call execute.." + str);
    }

}
