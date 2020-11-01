package playground.modernjava.datetime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FlightTimeSimulator {
    public static void main(String[] args) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");

        // 서울발 로스엔젤레스 국제 공항(LAX)행 출발
        LocalDateTime leavingDateTime = LocalDateTime.of(2018, Month.MAY, 9, 17, 20);
        ZoneId leavingZone = ZoneId.of("Asia/Seoul");
        ZonedDateTime departure = ZonedDateTime.of(leavingDateTime, leavingZone);
        System.out.printf("출발 : %s (%s)%n", departure.format(format), leavingZone);

        // 12시간 후 LAX 도착
        ZoneId arrivingZone = ZoneId.of("America/Los_Angeles");
        // 현지 기준 도착 시간 계산
        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone).plusHours(12);
        System.out.printf("도착 : %s (%s)%n", arrival.format(format), arrivingZone);

        // 섬머타임 적용 여부 확인
        if (arrivingZone.getRules().isDaylightSavings(arrival.toInstant())) {
            System.out.printf("  (%s 섬머타임 시간 적용.)%n", arrivingZone);
        } else {
            System.out.printf("  (%s 표준 시간 적용.)%n", arrivingZone);
        }
    }
}
