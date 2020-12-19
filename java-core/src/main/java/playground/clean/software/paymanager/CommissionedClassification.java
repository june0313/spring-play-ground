package playground.clean.software.paymanager;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommissionedClassification implements PaymentClassification {
    private final double salary;
    private final double commissionRate;
}
