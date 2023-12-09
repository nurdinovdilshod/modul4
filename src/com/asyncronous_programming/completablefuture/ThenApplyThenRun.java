package com.asyncronous_programming.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class ThenApplyThenRun {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        thenApply
//        method1();
//        method3();

        ExecutorService executor = Executors.newFixedThreadPool(10);

        CompletableFuture<Integer> errorMessage = CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            if (random.nextBoolean()) {
                throw new RuntimeException("Error message");
            }
            return 12 / 4;
        }).handle((number, ex) -> {
            if (ex != null) {
                System.out.println("Error ::" + ex.getMessage());
                return -1;
            }
            System.out.println("Successfully returned");
            return number;
        });
        System.out.println(errorMessage.get());
    }

    private static void method3() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> errorMessage = CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            if (random.nextBoolean()) {
                throw new RuntimeException("Error message");
            }
            return 12 / 4;
        }).exceptionally((ex) -> {
            System.out.println("Error " + ex.getMessage());
            return 0;
        });
        System.out.println(errorMessage.get());
    }

    private static void method1() throws InterruptedException {
        CompletableFuture<String> myNamecompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread());
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "DILSHOD";
        });
        CompletableFuture<String> fullNameCompletableFuture = myNamecompletableFuture.thenApply(name -> {
            try {
                System.out.println(Thread.currentThread());
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Nuriddinov " + name;
        });
        System.out.println(Thread.currentThread());
        fullNameCompletableFuture.thenAccept(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(Thread.currentThread());
                System.out.println(s);
            }
        });
        Thread.sleep(1000);
    }
}
