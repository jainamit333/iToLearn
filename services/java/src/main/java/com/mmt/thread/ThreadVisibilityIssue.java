package com.mmt.thread;

/**
 * Created by amit on 29/10/16.
 */
public class ThreadVisibilityIssue {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(5000);
        number = 42;
        ready = true;
    }
}
