package playground.modernjava.datetime;

import java.time.*;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;

public class TemporalQueriesExample {
    public static void main(String[] args) {
        TemporalQuery<TemporalUnit> chronoUnitQuery = TemporalQueries.precision();
        System.out.printf("LocalDate 정밀도 : %s%n", LocalDate.now().query(chronoUnitQuery));
        System.out.printf("LocalDateTime 정밀도 : %s%n", LocalDateTime.now().query(chronoUnitQuery));
        System.out.printf("YearMonth 정밀도 : %s%n", YearMonth.now().query(chronoUnitQuery));
        System.out.printf("Instant 정밀도 : %s%n", Instant.now().query(chronoUnitQuery));

        TemporalQuery<ZoneId> zoneIdQuery = TemporalQueries.zoneId();
        System.out.printf("ZonedDateTime의 Zone Id : %s%n", ZonedDateTime.now().query(zoneIdQuery));
        System.out.printf("ZonedDateTime의 Zone Id : %s%n", ZonedDateTime.now().getZone());

        // ZonedDateTime에서 현재 LocalTime 값 구하기
        TemporalQuery<LocalTime> localQuery = TemporalQueries.localTime();
        ZonedDateTime losAngelesZonedDateTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.printf("ZonedDateTime의 시간 : %s%n", losAngelesZonedDateTime.query(localQuery));
        System.out.printf("ZonedDateTime의 시간 : %s%n", losAngelesZonedDateTime.toLocalTime());
        System.out.printf("ZonedDateTime의 시간 : %s%n", losAngelesZonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Seoul")));
        System.out.printf("ZonedDateTime의 시간 : %s%n", losAngelesZonedDateTime.withZoneSameLocal(ZoneId.of("Asia/Seoul")));
    }
}
