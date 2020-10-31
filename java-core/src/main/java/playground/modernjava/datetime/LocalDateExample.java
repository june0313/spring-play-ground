package playground.modernjava.datetime;

import java.time.LocalDate;
import java.time.Month;

public class LocalDateExample {
    public static void main(String[] args) {
        // 현재 시스템의 기본 타임존 정보를 읽어와서 생성 (로컬 타임존)
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1990, Month.of(3), 13);
        LocalDate nextBDay = birthday.withYear(today.getYear());

        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }

        System.out.println(nextBDay);
        System.out.println(Month.JANUARY);
        System.out.println(Month.of(2));
    }
}
