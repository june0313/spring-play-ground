package playground.clean.software.paymanager;

import lombok.Getter;

@Getter
public class ServiceCharge {
    private long date;
    private double amount;

    public ServiceCharge(long date, double amount) {
        this.date = date;
        this.amount = amount;
    }
}
