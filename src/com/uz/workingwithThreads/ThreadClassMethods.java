package com.uz.workingwithThreads;

public class ThreadClassMethods {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 15; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread()+"->"+i);
            }
        };
        var thread1 = new Thread(runnable, "Thread one ->");
        var thread2 = new Thread(runnable, "Thread two ->");
        thread1.start();
        thread1.join(1000    );
        thread2.start();
        System.out.println("Hello PDP");
    }
}
