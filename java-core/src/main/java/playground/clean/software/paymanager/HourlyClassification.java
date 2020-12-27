package playground.clean.software.paymanager;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class HourlyClassification implements PaymentClassification {
    private final double hourlyRate;
    private Map<Long, TimeCard> timeCardMap;

    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
        this.timeCardMap = new HashMap<>();
    }

    public void addTimeCard(TimeCard tImeCard) {
        this.timeCardMap.put(tImeCard.getDate(), tImeCard);
    }

    public TimeCard getTimeCard(long date) {
        return this.timeCardMap.get(date);
    }
}
