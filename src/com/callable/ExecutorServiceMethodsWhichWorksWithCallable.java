package com.callable;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceMethodsWhichWorksWithCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int threadCount = Runtime.getRuntime().availableProcessors();
        System.out.println(threadCount);
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        Callable<String> callable = () -> {
            Thread.sleep(2000);
            return "Response";
        };

        Callable<String> callable2 = () -> {
            Thread.sleep(3000);
            return "Response 2";
        };

        Callable<String> callable3 = () -> {
            Thread.sleep(2000);
            return "Response 3";
        };
       /* try {
            List<Future<String>> futures = executorService.invokeAll(List.of(callable, callable2, callable3));
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }*/
        String response = executorService.invokeAny(List.of(callable, callable2, callable3));
        System.out.println(response);
    }
}
