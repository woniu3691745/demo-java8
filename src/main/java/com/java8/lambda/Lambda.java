package com.java8.lambda;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.function.BinaryOperator;

/**
 * 描述:
 *
 * Lambda表达式（也称为闭包）是Java 8中最大和最令人期待的语言改变。
 * 它允许我们将
 * 1、函数当成参数传递给某个方法
 * 2、把代码本身当作数据处理
 * link: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 *
 * @author lidongliang
 * @create 2017-11-16 10:24
 */
public class Lambda {

    public static void main(String[] args) {

        Arrays.asList( "a", "b", "d" ).forEach(e -> System.out.println( e ));
        Arrays.asList( "a", "b", "d" ).forEach( ( String e ) -> System.out.println( e ) );

        Arrays.asList( "a", "b", "d" ).forEach( e -> {
            System.out.print( e );
            System.out.print( e );
        } );

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
