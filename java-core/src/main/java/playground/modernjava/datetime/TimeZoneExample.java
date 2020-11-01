package playground.modernjava.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TimeZoneExample {
    public static void main(String[] args) {
        List<String> timeZoneList = new ArrayList<>(ZoneId.getAvailableZoneIds());
        Collections.sort(timeZoneList);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        for (String timeZoneId : timeZoneList) {
            ZoneId zone = ZoneId.of(timeZoneId);

            ZonedDateTime zdt = localDateTime.atZone(zone);
            System.out.println(zdt);

            ZoneOffset offset = zdt.getOffset();

            int secondsOfHour = offset.getTotalSeconds() / 60 / 60;

            if (secondsOfHour != 0) {
                System.out.printf("%25s %8s%n", zone, offset);
            }
        }
    }
}
