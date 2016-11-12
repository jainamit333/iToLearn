package com.mmt.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;

/**
 * Created by amit on 23/10/16.
 */
public class Test {

    public static void main(String[] args) {

//        GenerateInt generateInt = new GenerateInt();
//            Boolean isEven = true;
//            Thread odd = new Thread(new ThreadTwo(1,isEven));
//            Thread even = new Thread(new ThreadTwo(0,isEven));
//            odd.start();;
//            even.start();
//        for (int i = 0;i<100;i++){
//            new ThreadOne(generateInt).start();
//        }

//        List<Integer> list = new ArrayList();
//        int limit = 100;
//        for (int i = 0; i < limit; i++) {
//            list.add(i);
//        }
//
//        ThreadOne one = new ThreadOne(null,list);
//        Thread two = new Thread(new ThreadTwo(list));
//        one.start();
//        two.start();

//        NumberPrinter numberPrinter = new NumberPrinter();
//        EvenThread evenThread = new EvenThread(0,20,numberPrinter);
//        OddThread oddThread = new OddThread(1,20,numberPrinter);
//        oddThread.start();
//        evenThread.start();;


//        CountDownLatch countDownLatch = new CountDownLatch(2);
//        Thread starter = new Thread(new CountDownLatchExample(countDownLatch));
//        Thread worker1 = new Thread(new SimpleThread(countDownLatch));
//        Thread worker2 = new Thread(new SimpleThread(countDownLatch));
//        Thread worker3 = new Thread(new SimpleThread(countDownLatch));
//
//        worker1.start();worker2.start();worker3.start();
//        starter.start();


//

//        Semaphore semaphore = new Semaphore(2);
//        new SemaphoresExample(semaphore,1).start();
//        new SemaphoresExample(semaphore,22).start();
//        new SemaphoresExample(semaphore,2).start();
//        new SemaphoresExample(semaphore,3).start();
//        new SemaphoresExample(semaphore,4).start();
//        new SemaphoresExample(semaphore,5).start();


        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(new SimpleThreadBarrier(cyclicBarrier)).start();
        new Thread(new SimpleThreadBarrier(cyclicBarrier)).start();
        new Thread(new SimpleThreadBarrier(cyclicBarrier)).start();
        new Thread(new SimpleThreadBarrier(cyclicBarrier)).start();
        new Thread(new SimpleThreadBarrier(cyclicBarrier)).start();
        new Thread(new SimpleThreadBarrier(cyclicBarrier)).start();
    }
}
