package com.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2017-11-16 13:59
 */
public class HelloServiceProxy implements InvocationHandler {

    /**
     * 真实服务对象
     */
    private Object target;

    /**
     * 绑定委托对象并返回一个代理类
     *
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        // 去的代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 通过代理对象调用方法首先进入这个方法
     *
     * @param proxy  代理对象
     * @param method 被调用方法
     * @param args   方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("###################我是JDK动态代理####################");
        Object result = null;
        // 反射方法前调用
        System.out.println("我准备说hello。");
        // 执行方法，相当于调用 HelloServiceImpl 类的 sayHello 方法
        result = method.invoke(target, args);
        // 反射方法后调用
        System.out.println("我说过了hello了。");
        return result;
    }
}
