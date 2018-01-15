package com.utils.currentlimit;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.Executors;

/**
 * ${DESCRIPTION}
 *
 * @author lidongliang
 * @create 2018-01-15 下午9:24
 **/
public class RateLimiterTest {
    public static void main(String[] args) {
        testRateLimiter();
    }

    /**
     * RateLimiter类似于JDK的信号量Semphore，他用来限制对资源并发访问的线程数
     */
    public static void testRateLimiter() {

        ListeningExecutorService executorService = MoreExecutors
                .listeningDecorator(Executors.newFixedThreadPool(5));

        // 每秒不超过4个任务被提交
        RateLimiter limiter = RateLimiter.create(100);


        for (int i = 0; i < 50; i++) {
            // 请求RateLimiter, 超过permits会被阻塞
            limiter.acquire();

            executorService.submit(new Task3("is " + i));
        }
    }

}
