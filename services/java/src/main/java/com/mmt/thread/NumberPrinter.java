package com.mmt.thread;

/**
 * Created by amit on 29/10/16.
 */
public class NumberPrinter {

    private Boolean isEvenPrinted = false;

    public void printEvent(int number) throws InterruptedException {

        synchronized (this) {
            if (isEvenPrinted)
                wait();
            System.out.println(number);
            isEvenPrinted = !isEvenPrinted;
            notify();

        }
    }

    public void printOdd(int number) throws InterruptedException{

        synchronized (this){

            if(!isEvenPrinted)
                wait();
            System.out.println(number);
            isEvenPrinted = !isEvenPrinted;
            notify();
        }
    }


}
