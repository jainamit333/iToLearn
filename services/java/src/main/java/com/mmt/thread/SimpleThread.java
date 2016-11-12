package com.mmt.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by amit on 1/11/16.
 */
public class SimpleThread implements Runnable {

    CountDownLatch countDownLatch;

    public  SimpleThread(CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }

    @Override
    public void run() {


        System.out.println("Waiting for a latch");

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Execute after a latch");
    }
}
