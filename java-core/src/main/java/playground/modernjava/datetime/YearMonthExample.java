package playground.modernjava.datetime;

import java.time.LocalDate;
import java.time.YearMonth;

public class YearMonthExample {
    public static void main(String[] args) {
        YearMonth date = YearMonth.now();
        System.out.println(date);
        System.out.println("length of month : " + date.lengthOfMonth());

        LocalDate now = LocalDate.now();
        System.out.println(now.lengthOfMonth());
        System.out.println(now.lengthOfYear());
        System.out.println(date.lengthOfYear());

        System.out.println(date.plusYears(1).lengthOfYear());
    }
}
