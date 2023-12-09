package com.working_with_time.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Calendar {
    public static final String RESET = "\033[0m";
    public static final String RED_BRIGHT = "\033[0;91m";
    public static final String CYAN_BRIGHT = "\033[0;96m";

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2023, 2, 1);
        printCalendar(localDate);

    }

    private static void printCalendar(LocalDate localDate) {
        Month month = localDate.getMonth();
        int year = localDate.getYear();
        System.out.printf("%s%s, %d, %s%n", CYAN_BRIGHT, month, year, RESET);
        for (DayOfWeek dayOfWeak : DayOfWeek.values()) {
            System.out.printf("%s\t", dayOfWeak.name().substring(0, 2));
        }
        System.out.println();
        int firstDay = localDate.getDayOfWeek().getValue() - 1;
        for (int i = 1; i <= firstDay; i++) {
            System.out.printf("\t");
        }
        int days = month.length(localDate.isLeapYear());
        LocalDate cur = LocalDate.now();
        for (int day = 1; day <= days; day++) {
            if (year == cur.getYear() && month.equals(cur.getMonth()) && day == cur.getDayOfMonth())
                System.out.printf("%s%02d%s\t", RED_BRIGHT, day, RESET);
            else
                System.out.printf("%s%02d%s\t", CYAN_BRIGHT, day, RESET);
            if ((day + firstDay) % 7 == 0) System.out.println();

        }
    }
}
