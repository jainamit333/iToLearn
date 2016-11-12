package com.mmt.thread;

/**
 * Created by amit on 30/10/16.
 */
public class OddThread extends Thread {

    int start;
    int max;
    NumberPrinter numberPrinter;

    public OddThread(int start,int max,NumberPrinter numberPrinter){
        this.start = start;
        this.max = max;
        this.numberPrinter = numberPrinter;
    }

    public void run(){

        for (int i = start;i<max;i = i+2){
            try {
                numberPrinter.printOdd(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
