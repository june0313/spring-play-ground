package playground.clean.software.paymanager;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class CommissionedClassification implements PaymentClassification {
    private final double salary;
    private final double commissionRate;
    private final Map<Long, SalesReceipt> salesReceiptMap;

    public CommissionedClassification(double salary, double commissionRate) {
        this.salary = salary;
        this.commissionRate = commissionRate;
        this.salesReceiptMap = new HashMap<>();
    }

    public void addSalesReceipt(SalesReceipt salesReceipt) {
        this.salesReceiptMap.put(salesReceipt.getDate(), salesReceipt);
    }
}
