package com.working_with_time.time_api;

import java.time.DayOfWeek;
import java.time.YearMonth;

public class AdditionalTypes {
    public static void main(String[] args) {
        for (DayOfWeek value : DayOfWeek.values()) {
            System.out.println(value);
        }
        System.out.println(YearMonth.of(2001, 8));

    }
}
