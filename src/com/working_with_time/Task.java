package com.working_with_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Task {
    static Scanner scanner = new Scanner(System.in);
    public static final String RESET = "\033[0m";
    public static final String RED_BRIGHT = "\033[0;91m";
    public static final String CYAN_BRIGHT = "\033[0;96m";

    public static void main(String[] args) {
        months();
    }

    private static void months() {
        System.out.print("Enter Year :");
        int year = scanner.nextInt();
        for (int i = 1; i <= 12; i++) {
            LocalDate localDate = LocalDate.of(year, i, 1);
            printMonth(localDate);
        }
    }

    private static void printMonth(LocalDate localDate) {
        Month month = localDate.getMonth();
        int year = localDate.getYear();
        System.out.printf("\t%s, %s %n", month, year);
        for (DayOfWeek value : DayOfWeek.values()) {
            System.out.print(value.name().substring(0, 2) + "\t");
        }
        System.out.println();
        int firstDay = localDate.getDayOfWeek().getValue()-1;

        System.out.print("\t".repeat(firstDay));
        int days = month.maxLength();
        for (int day = 1; day <=days; day++) {
            System.out.printf("%02d \t",day);
            if ((day+firstDay)%7==0) System.out.println();
        }
        System.out.println();

    }
}
