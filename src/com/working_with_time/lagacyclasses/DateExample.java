package com.working_with_time.lagacyclasses;

import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        Date currentTime = new Date();
//        date.setTime(286505005000L);
//        System.out.println(date);
        Date blockTill = new Date(System.currentTimeMillis() -20 * 60 * 1000);
        System.out.println(currentTime);
        System.out.println(blockTill);
        if (currentTime.before(blockTill))
            System.out.println("You are blocked for 20 minutes");
        else System.out.println("Welcome");
    }
}
