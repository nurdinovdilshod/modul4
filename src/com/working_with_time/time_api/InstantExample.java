package com.working_with_time.time_api;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class InstantExample {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(LocalDate.of(1995, 10, 3).get(ChronoField.DAY_OF_YEAR));
        System.out.println(now.plusYears(1).isLeapYear());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfWeek());
        System.out.println(now.get(ChronoField.DAY_OF_YEAR));
        System.out.println(now.get(ChronoField.DAY_OF_MONTH));

    }
}
