package playground.modernjava.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ParsingExample {
    public static void main(String[] args) {
        String input = "2020 03 13";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate date = LocalDate.parse(input, formatter);
        LocalDate date2 = LocalDate.parse("2020-12-12", DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(date);
        System.out.println(date2);
        System.out.println(date.toString());
    }
}
