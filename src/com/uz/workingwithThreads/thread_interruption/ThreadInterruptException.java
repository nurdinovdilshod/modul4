package com.uz.workingwithThreads.thread_interruption;

public class ThreadInterruptException {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                }
            }
        };
        Thread th1 = new Thread(runnable, "Thread 1");
        th1.start();
        System.out.println("Hello PDP");
    }
}
