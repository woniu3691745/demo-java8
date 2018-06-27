package com.concurrency.lesson03.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class AbstractServiceImpl1 extends AbstractService {

    private Logger loger = LoggerFactory.getLogger(AbstractServiceImpl1.class);

    public AbstractServiceImpl1(CountDownLatch latch) {
        super(latch);
    }

    @Override
    protected void doStart() throws Exception {
        loger.info("{}", "doStart1");
    }

}
