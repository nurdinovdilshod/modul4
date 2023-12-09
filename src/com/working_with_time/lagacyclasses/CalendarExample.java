package com.working_with_time.lagacyclasses;

import java.util.Calendar;

public class CalendarExample {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        System.out.println(calendar.getFirstDayOfWeek());
        System.out.println(calendar.get(Calendar.MONTH));
    }
}
