package com.mmt.thread;

import java.util.List;

/**
 * Created by amit on 23/10/16.
 */
public class ThreadOne extends Thread {
    GenerateInt generateInt;
    List<Integer> list;
    ThreadOne(GenerateInt generateInt,List<Integer> list){
        this.generateInt = generateInt;
        this.list=list;
    }

    public void run() {

        list.stream().forEach(i ->System.out.println(i));
    }
}
