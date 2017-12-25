package com.interview;

/**
 * static 作用域
 * 静态导入 static import
 * <p>
 * 变量的作用域分为四个级别：类级、对象实例级、方法级、块级
 */
public class StaticOperator {

    private static String a = "1"; //类级变量
    public int i;   //对象级变量，默认为0

    // 类级别作用域
    static {
        System.out.println("3");
        //块级变量，只能在块内部访问
    }

    {
        System.out.println("2");
    }

    private StaticOperator() {
        System.out.println("4");
    }

    public static void main(String[] args) {
        StaticOperator test = new StaticOperator();
        System.out.println(StaticOperator.a);
    }

}
