package com.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2017-11-16 20:52
 */
public class HelloServiceCgLib implements MethodInterceptor {

    private Object target;

    /**
     * 创建代理对象
     *
     * @param target
     * @return
     */
    Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    // 回调方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("################我是CGLIB的动态代理###############");
        // 反射方法前调用
        System.out.println("我准备说hello");
        Object returnObj = methodProxy.invokeSuper(o, objects);
        // 反射方法后调用
        System.out.println("我说过hello了");
        return returnObj;
    }
}
