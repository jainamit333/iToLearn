package com.mmt.thread;

/**
 * Created by amit on 29/10/16.
 */
public class EvenThread extends Thread {

    int start;
    int max;
    NumberPrinter numberPrinter;

    public EvenThread(int start,int max,NumberPrinter numberPrinter){
        this.start = start;
        this.max = max;
        this.numberPrinter = numberPrinter;
    }

    public void run(){

        for (int i = start;i<max;i = i+2){
            try {
                numberPrinter.printEvent(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
