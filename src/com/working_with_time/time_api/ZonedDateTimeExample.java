package com.working_with_time.time_api;

import java.time.Period;

public class ZonedDateTimeExample {
    public static void main(String[] args) {
//        System.out.println(ZonedDateTime.now(ZoneId.of("America/Los_Angeles")));
//        ZoneId.getAvailableZoneIds().forEach(System.out::println);
        Period period=Period.ofYears(40);
        Period period1=Period.ofDays(20000);
        System.out.println(Period.ofDays(20000).toTotalMonths());
        System.out.println(period.toTotalMonths());
    }
}
