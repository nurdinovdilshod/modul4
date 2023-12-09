package com.thread_local;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WithoutThreadLocal {
    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                a(new Date());
            });
        }
    }

    static void a(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String formattedDate = simpleDateFormat.format(date);
        System.out.println(formattedDate);
    }
}
