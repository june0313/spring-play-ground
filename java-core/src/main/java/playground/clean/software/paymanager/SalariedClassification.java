package playground.clean.software.paymanager;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SalariedClassification implements PaymentClassification {
    private double salary;
}
