package com.atomocity;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongClassTest {

    public static void main(String[] args) throws InterruptedException {
        var counter = new AtomicLong();
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread() + "::" + counter.incrementAndGet());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
        Thread.sleep(2000);
        System.out.println(counter.get());
        Random random = new Random();
        int b = random.nextInt(9000, 11000);
        System.out.println(b);
        counter.set(Math.max(counter.get(), b));// error -> race Condition
        counter.accumulateAndGet(b, Math::max);

        System.out.println(counter.get());

    }
}