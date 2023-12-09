package com.callable;

import java.util.concurrent.*;

public class CallableNeedingExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        Uzcard to Humo
//        Sender to receiver
//       Sender check
//        receiver check
//        transfer

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Long begin = System.currentTimeMillis();

        Callable<Boolean> checkUzcardValid = () -> {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Checking sender................");
            return true;
        };
        Callable<Boolean> checkHumoValid = () -> {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Checking receiver................");
            return true;
        };
        Future<Boolean> uzcardCheckResponse = executorService.submit(checkUzcardValid);
        Future<Boolean> humoCheckResponse = executorService.submit(checkHumoValid);

        System.out.println(uzcardCheckResponse.get());
        System.out.println(humoCheckResponse.get());
        Long end = System.currentTimeMillis();
        System.out.println(end - begin);
        executorService.shutdown();
        if (!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}
