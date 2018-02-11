package com.concurrency.lesson03.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public abstract class AbstractService implements Service {

    private Logger loger = LoggerFactory.getLogger(AbstractService.class);

    protected boolean started = false;
    protected final CountDownLatch latch;

    public AbstractService(CountDownLatch latch) {
        this.latch = latch;
    }

    protected abstract void doStart() throws Exception;

    @Override
    public boolean isStarted() {
        return started;
    }

    @Override
    public void start() {
        new ServiceStarter().start();
    }

    @Override
    public void stop() {

    }

    class ServiceStarter extends Thread {
        @Override
        public void run() {
            final String serviceName = AbstractService.this.getClass().getSimpleName();
            loger.info("Starting {}", serviceName);
            loger.info("{}", "run ...");
            try {
                doStart();
                started = true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
                loger.info("{}", "finally ...");
            }
        }
    }
}
