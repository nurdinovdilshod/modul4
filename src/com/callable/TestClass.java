package com.callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestClass {
    public static void main(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();
        System.out.println(l);
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        executorService.submit(runnable);
        executorService.shutdown();
        long l1 = System.currentTimeMillis();
        System.out.println(l1);
        System.out.println("Timeeeeeeee"+(l1 - l));

    }
}
