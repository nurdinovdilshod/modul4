package com.uz.workingwithThreads.daemons;

public class ThreadPriorities {
    public static void main(String[] args) {
        var th1 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getPriority());
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"Thread for test");
        th1.setPriority(1);
        th1.start();
    }
}
