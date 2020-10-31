package playground.modernjava.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class FormattingExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formattedDate = now.format(formatter);
        System.out.println(formattedDate);
        System.out.println(now.toString());

        DateTimeFormatter customFormatter = new DateTimeFormatterBuilder().appendLiteral("## 오늘 일자 : ##\n")
                .appendLiteral("- 연 -> ")
                .appendValue(ChronoField.YEAR)
                .appendLiteral("\n- 월 -> ")
                .appendValue(ChronoField.MONTH_OF_YEAR)
                .appendLiteral("\n- 시간 -> ")
                .appendPattern("HH")
                .appendLiteral(":")
                .appendValue(ChronoField.MINUTE_OF_HOUR)
                .toFormatter();

        System.out.println(LocalDateTime.now().format(customFormatter));
    }
}
