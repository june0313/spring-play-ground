package playground.clean.software.paymanager;

import lombok.Getter;

@Getter
public class TimeCard {
    private long date;
    private double hours;

    public TimeCard(long date, double hours) {
        this.date = date;
        this.hours = hours;
    }
}
