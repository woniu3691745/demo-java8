package com.interview;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2018-01-02 17:24
 */
public class TryCatch {

    private static int test(int i) {
        try {
            FileInputStream file = new FileInputStream("D:/123.txt");
            System.out.println(file);
            return 0;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("catch");
            return 1;
        } finally {
            System.out.println("finally");
            return 2;
        }
    }

    public static void main(String[] args) {
        int i = 1;
        System.out.println(test(i));
    }
}
