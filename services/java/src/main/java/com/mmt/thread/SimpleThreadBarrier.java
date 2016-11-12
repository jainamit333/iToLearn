package com.mmt.thread;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by amit on 1/11/16.
 */
public class SimpleThreadBarrier implements Runnable {

    CyclicBarrier cyclicBarrier;

    public SimpleThreadBarrier(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {

        System.out.println("waiting");

        try {
            cyclicBarrier.await();

            Thread.sleep(1000l);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("thread started");
    }
}
