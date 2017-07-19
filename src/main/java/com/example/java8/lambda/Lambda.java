package com.example.java8.lambda;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 * Created by lidongliang on 2017/7/10.
 * Lambda 表达式
 */
public class Lambda {

    public static void main(String[] args) {

        // Lambda表达式不包含参数，使用空括号（）表示没有参数。
        Runnable noArgument = () -> System.out.println("Hello World");

        // Lambda表达式包含且只包含一个参数，可省略参数的括号。
        ActionListener oneArgument = event -> System.out.println("button clicked");

        Runnable multiStatement = () -> {
            System.out.println("Hello");
            System.out.println("World");
        };

        // Lambda表达式包含多个参数
        BinaryOperator<Long> add = (x, y) -> x + y;

        // Lambda参数类型有编译器推断得出，也可以显示声明
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;

    }
}
