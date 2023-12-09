package com.uz.workingwithThreads.daemons;

public class DaemonThreadingTest {
    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());

        Runnable runnable = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Active threads count: " + Thread.activeCount() + " i =" + i);
                    Thread.sleep(50);
                    String name = Thread.currentThread().getName();
                    System.out.println(name);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        var th1 = new Thread(runnable);
        th1.setDaemon(true);
        th1.start();
        System.out.println("Hello PDP");
        Thread.sleep(310);
    }
}

class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        System.out.println(thread.getName()+"::"+throwable.getMessage());
    }
}
