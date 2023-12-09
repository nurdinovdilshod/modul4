package com.callable;

import java.util.concurrent.*;

public class FutureMethodsExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<String> future = executorService.submit(() -> {
            System.out.println("Connecting to API...");
            Thread.sleep(2000);
              return "Response from API";
        });
       /* while (!future.isDone()) {
            System.out.println("API still did not return response");
            Thread.sleep(200);
        }*/
        System.out.printf("Response is : '%s' ", future.get());
        String s = future.get(1, TimeUnit.MILLISECONDS);
        System.out.println(s);


    }
}
