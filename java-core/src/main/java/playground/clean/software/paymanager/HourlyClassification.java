package playground.clean.software.paymanager;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HourlyClassification implements PaymentClassification {
    private final double hourlyRate;
}
