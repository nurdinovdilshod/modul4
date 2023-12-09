package com.asyncronous_programming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Task2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> calculator =/* CompletableFuture.supplyAsync((a,b) ->;*/addAsync(10,15);
        calculator.thenApply(result -> {
            System.out.println("Res :" + result);
            return result;
        });
        calculator.get();
    }

    private static CompletableFuture<Integer> addAsync(int a, int b) {
        return CompletableFuture.supplyAsync(() -> a + b);
    }

}
