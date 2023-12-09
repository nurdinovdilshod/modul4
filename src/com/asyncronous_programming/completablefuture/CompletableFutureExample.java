package com.asyncronous_programming.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> completableFuture = new CompletableFuture<>();
//        completableFuture.complete("Completed");
//        System.out.println(completableFuture.get());

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        /*CompletableFuture.runAsync(() -> {
            System.out.println("Running on Thread " + Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello from RunAsync");
        }, executorService);*/

//        register();
       /* System.out.println(returnSuccessMessage());
        for (int i = 0; i < 10; i++) {
            System.out.println("Message " + i);
            Thread.sleep(20);
        }*/
        CompletableFuture<Object> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Value from completable future";
        }, executorService);
        System.out.println(completableFuture.get());
    }

    private static String returnSuccessMessage() throws InterruptedException {
        Thread.sleep(500);
        return "Successfully registered please check your inbox";
    }

    private static void register() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletableFuture.runAsync(() -> {
            System.out.println("User data send to database " + Thread.currentThread());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("user data saved to database    " + Thread.currentThread());
        }, executor);
        CompletableFuture.runAsync(() -> {
            System.out.println("Email sending " + Thread.currentThread());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Email Sent   :::" + Thread.currentThread());
        }, executor);
    }
}
