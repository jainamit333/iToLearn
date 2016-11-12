package com.mmt.thread;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by amit on 1/11/16.
 */
public class FutureTaskExample {

    FutureTask<List<Integer>> futureTask = new FutureTask(new Callable() {
        @Override
        public List<Integer> call() throws Exception {
            System.out.println("Starting thread");
            Thread.sleep(2000l);
            System.out.println("Waiting thread");
            return Collections.singletonList(23);
        }
    });


    public void getFutureResult() throws ExecutionException, InterruptedException {

        System.out.println("will call get");
        Thread thread = new Thread(futureTask);
        thread.start();
        List<Integer> list  =  futureTask.get();
        System.out.println(list);

    }
}
