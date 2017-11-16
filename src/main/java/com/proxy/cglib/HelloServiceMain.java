package com.proxy.cglib;

import com.proxy.jdkproxy.impl.HelloServiceImpl;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2017-11-16 21:01
 */
public class HelloServiceMain {

    public static void main(String[] args) {

        HelloServiceImpl helloService = new HelloServiceImpl();
        HelloServiceCgLib helloHandler = new HelloServiceCgLib();
        HelloServiceImpl helloService1 = (HelloServiceImpl)helloHandler.getInstance(helloService);
        helloService1.syaHello("lidl");

    }

}
