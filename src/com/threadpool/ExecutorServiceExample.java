package com.threadpool;


import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException {
        m1();
//        m2();
    }

    private static void m2() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//        scheduledExecutorService.schedule(() -> System.out.println("Time is " + new Date()), 1, TimeUnit.SECONDS);
       /* scheduledExecutorService.scheduleAtFixedRate(
                () -> System.out.println("Time is " + new Date()),
                2, 1,
                TimeUnit.SECONDS);*/
        scheduledExecutorService.scheduleWithFixedDelay(
                () -> {
                    System.out.println("Time is " + new Date());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                },
                2, 1,
                TimeUnit.SECONDS);
    }

    private static void m1() throws InterruptedException {
        //        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 200; i++) {
            final int taskID = i;
            Runnable runnable = () -> {
                try {
                    System.out.printf(Thread.currentThread() + ":::" +
                            "Task executing (Task number is %d) Thread count %d %n", taskID, Thread.activeCount());
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            executorService.execute(runnable);
        }
//        executorService.shutdown();
//        executorService.awaitTermination(2,TimeUnit.SECONDS);
        executorService.shutdownNow();
        if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("Shutting Down");
            executorService.shutdownNow();
        }
    }
}
