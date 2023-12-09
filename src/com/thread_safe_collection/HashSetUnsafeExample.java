package com.thread_safe_collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class HashSetUnsafeExample {
    public static void main(String[] args) throws InterruptedException {

//        var set = new HashSet<Integer>();
        var set = ConcurrentHashMap.<Integer>newKeySet();
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                set.add(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {

                }
            }
        };
        Runnable runnable2 = () -> {
            for (int i = 1000; i < 2000; i++) {
                set.add(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            }
        };
        new Thread(runnable).start();
        new Thread(runnable2).start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println(set.size());
    }
}
