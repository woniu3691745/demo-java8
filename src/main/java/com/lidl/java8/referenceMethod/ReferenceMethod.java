package com.lidl.java8.referenceMethod;

/**
 * Created by lidongliang on 2017/7/12.
 * 方法引用
 */
public class ReferenceMethod {

    /**
     * artist -> artist.getName()
     * Artist::getName
     * Lambda表达式和方法引用是等价的一种结构
     * 凡是使用Lambda表达式的地方，就可以使用方法引用
     *
     * 构造函数
     * (name, nationality) -> new Artist(name, nationality)
     * Artist::new
     *
     * 数组
     * String[]::new
     */
}
