package com.working_with_time.lagacyclasses;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDateFormatExample {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyy");
        String day = "17082001";
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println(simpleDateFormat.parse(day));
                } catch (Exception e) {
                }
            });
        }
        executorService.shutdown();
    }
}