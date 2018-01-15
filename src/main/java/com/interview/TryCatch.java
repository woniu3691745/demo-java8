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

    public static String output = "";

    private String abc = "123";

    private static void foo(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
        } catch (Exception e) {
            output += "2";
            return;
        } finally {
            output += "3";
        }
        output += 4;
    }

    public static void main(String[] args) {
//        int i = 1;
//        System.out.println(test(i));
        foo(0);
        foo(1);
        System.out.println(output);

    }


}
