package playground.clean.software.paymanager;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SalesReceipt {
    private final long date;
    private final double amount;
}
