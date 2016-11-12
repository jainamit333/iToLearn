package com.mmt.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by amit on 1/11/16.
 */
public class CountDownLatchExample implements Runnable{

    CountDownLatch countDownLatch;
    public CountDownLatchExample(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Starting Thead"+this.getClass().getName());
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
        System.out.println("Started Thead"+this.getClass().getName());

    }
}
