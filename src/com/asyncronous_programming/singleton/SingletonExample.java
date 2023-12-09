package com.asyncronous_programming.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 500; i++)
            executorService.execute(() -> System.out.println(System.identityHashCode(Singleton.getInstance())));
    }
}
