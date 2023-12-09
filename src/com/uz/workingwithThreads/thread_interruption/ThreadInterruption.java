package com.uz.workingwithThreads.thread_interruption;

public class ThreadInterruption {
    public static void main(String[] args) {
//        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable)
                -> System.out.println(thread.getName() + "::" + throwable.getMessage()));
        Runnable runnable = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        var th1 = new Thread(runnable);
        th1.start();
        System.out.println("Hello PDP");
        th1.interrupt();
    }
}

class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        System.out.println(thread.getName() + "::" + throwable.getMessage());
    }
}

