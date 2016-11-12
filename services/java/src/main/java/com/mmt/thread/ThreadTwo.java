package com.mmt.thread;

import java.util.List;

/**
 * Created by amit on 24/10/16.
 */
public class ThreadTwo implements Runnable{
    int i ;
    List<Integer> list;
    public ThreadTwo(List<Integer> list){
        this.list=list;
    }
    public void run() {

       list.set(2,222);
        list.set(12,222); list.set(32,222); list.set(42,222); list.set(52,222);
    }
}
