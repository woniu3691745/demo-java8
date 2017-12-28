package com.proxy.jdkproxy;

import com.proxy.jdkproxy.impl.HelloServiceImpl;

/**
 * 描述: JDK的动态代理依靠接口实现
 *
 * @author lidongliang
 * @create 2017-11-16 14:07
 */
public class HelloServiceMain {

    public static void main(String[] args) {
        HelloServiceProxy helloHandler = new HelloServiceProxy();
        HelloService proxy = (HelloService) helloHandler.bind(new HelloServiceImpl());
        proxy.syaHello("李四");
    }

}
