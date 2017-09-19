package com.lidl.example;

/**
 * static 作用域
 * 静态导入 static import
 */
public class Static01 {

    private static String a = "1";

    {
        System.out.println("2");
    }

    static {
        System.out.println("3");
    }

    private Static01() {
        System.out.println("4");
    }

    public static void main(String[] args) {
        Static01 test = new Static01();
        System.out.println(Static01.a);
    }

}
