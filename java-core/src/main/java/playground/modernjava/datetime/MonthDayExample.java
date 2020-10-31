package playground.modernjava.datetime;

import java.time.Month;
import java.time.MonthDay;
import java.time.Year;

public class MonthDayExample {
    public static void main(String[] args) {
        MonthDay date = MonthDay.of(Month.MARCH, 13);

        System.out.println(date.isValidYear(1990));

        System.out.println(MonthDay.of(Month.FEBRUARY, 29).isValidYear(1990));
        System.out.println(MonthDay.of(Month.FEBRUARY, 29).isValidYear(1991));
        System.out.println(MonthDay.of(Month.FEBRUARY, 29).isValidYear(1992));
        System.out.println(MonthDay.of(Month.FEBRUARY, 29).isValidYear(1993));
        System.out.println(MonthDay.of(Month.FEBRUARY, 29).isValidYear(1996));

        System.out.println(Year.of(2020).length());
    }
}
