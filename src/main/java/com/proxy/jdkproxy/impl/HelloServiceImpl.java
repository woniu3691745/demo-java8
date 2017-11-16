package com.proxy.jdkproxy.impl;

        import com.proxy.jdkproxy.HelloService;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2017-11-16 13:58
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void syaHello(String name) {
        System.out.println("hello " + name);
    }
}
