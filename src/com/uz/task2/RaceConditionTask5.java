package com.uz.task2;

import java.util.concurrent.locks.ReentrantLock;

public class RaceConditionTask5 {
    private static volatile int counter = 0;
    private static final int ITERATIONS = 10000;

    public static void main(String[] args) throws InterruptedException {
        var lock=new ReentrantLock();
        Runnable incrementTask = () -> {
           lock.lock();
            for (int i = 0; i < ITERATIONS; i++) {
                counter++;
            }
            lock.unlock();
        };
        Thread th1 = new Thread(incrementTask);
        Thread th2 = new Thread(incrementTask);
        th1.start();
        th2.start();

//        th1.join();
//        th2.join();
        System.out.println("Counter value: " + counter);
    }
}
