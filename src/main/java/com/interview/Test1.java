package com.interview;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2018-01-10 16:01
 */
public class Test1 {

    public static void main(String args[]) {
        Thread t = new Thread(() -> print());
        t.start();
//        t.run();
        System.out.print("MT");
    }
    static void print() {
        System.out.print("DP");
    }

}
