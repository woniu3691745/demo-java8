package com.concurrency.lesson05;

import java.util.concurrent.Callable;

/**
 * 描述:
 * Callable接口只有一个方法call()
 *
 * @author lidongliang
 * @create 2017-11-22 13:55
 */
public class RealData implements Callable<String> {

    private String para;

    public RealData(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(i);
            Thread.sleep(1000);
        }
        return sb.toString();
    }
}
