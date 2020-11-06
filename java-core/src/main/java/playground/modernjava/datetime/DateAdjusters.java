package playground.modernjava.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import static java.time.temporal.TemporalAdjusters.*;
import static playground.modernjava.datetime.CustomTemporalAdjusters.*;

public class DateAdjusters {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.printf("%s 일의 요일은 %s 입니다.\n", localDate, dayOfWeek);
        System.out.printf("%s 일의 요일은 %s 입니다.\n", localDate, dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREA));
        System.out.printf("이번 달의 첫 번째 일 : %s%n", localDate.with(firstDayOfMonth()));
        System.out.printf("이번 달의 첫 번째 월요일 : %s%n", localDate.with(firstInMonth(DayOfWeek.MONDAY)));
        System.out.printf("이번 달의 마지막 일 : %s%n", localDate.with(lastDayOfMonth()));


        System.out.printf("현재 날짜 : %s, 리마인드 날짜 : %s\n", localDate, localDate.with(giftRemindExpireDate(3)));
        System.out.printf("현재 날짜 : %s, 리마인드 날짜 : %s\n", localDate, localDate.with(giftRemindExpireDate(6)));
        System.out.printf("현재 날짜 : %s, 리마인드 날짜 : %s\n", localDate, localDate.with(giftCardRemindExpireDate(30)));
        System.out.printf("현재 날짜 : %s, 리마인드 날짜 : %s\n", localDate, localDate.with(giftCardRemindExpireDate(60)));
        System.out.printf("현재 날짜 : %s, 리마인드 날짜 : %s\n", localDate, localDate.with(giftCardRemindExpireDate(89)));
    }
}
