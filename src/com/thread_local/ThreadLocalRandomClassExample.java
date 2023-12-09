package com.thread_local;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomClassExample {
    public static void main(String[] args) {
        ThreadLocalRandom threadLocalRandom=ThreadLocalRandom.current();
        System.out.println(threadLocalRandom.nextInt(100,1300));
    }
}
