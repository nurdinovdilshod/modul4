package com.uz.workingwithThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {
    private final String name;
    private final Lock lock = new ReentrantLock();

    MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            try {
                lock.lock();
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }finally {
                lock.unlock();
            }
            if (name.equalsIgnoreCase("Thread 1") && i == 3) throw new RuntimeException("Exception for testing");
            else System.out.println(this);
        }
    }

    @Override
    public String toString() {
        return name + "->";
    }
}

class DealingWithThreadExceptions {
    public static void main(String[] args) throws InterruptedException {

        var myThread1 = new MyThread("Thread 1");
        var myThread2 = new MyThread("Thread 2");
        var myThread3 = new MyThread("Thread 3");
        myThread1.start();
        myThread2.start();
        myThread3.start();
        Thread.sleep(120);
        throw new RuntimeException("Main thread exception");
    }

}
