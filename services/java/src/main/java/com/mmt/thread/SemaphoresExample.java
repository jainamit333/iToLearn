package com.mmt.thread;

import java.util.concurrent.Semaphore;

/**
 * Created by amit on 1/11/16.
 */
public class SemaphoresExample extends Thread{

    Semaphore semaphore;
    int i;
    SemaphoresExample(Semaphore semaphore,int i){
        this.semaphore = semaphore;
        this.i = i;
    }


    public void run(){
        try{
        System.out.println("will start"+i);
        semaphore.acquire();
        System.out.println("started sleeping"+i);
        Thread.sleep(1000l);
        System.out.println("started done sleeping"+i);
        System.out.println(i);
        semaphore.release();
        System.out.println("semaphore released"+i);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
