package playground.clean.software.paymanager;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class UnionAffiliation implements Affiliation {
    private double dues;
    private Map<Long, ServiceCharge> serviceChargeMap;

    public UnionAffiliation(double dues) {
        this.dues = dues;
        this.serviceChargeMap = new HashMap<>();
    }

    public void addServiceCharge(long date, double charge) {
        serviceChargeMap.put(date, new ServiceCharge(date, charge));
    }

    public ServiceCharge getServiceCharge(long date) {
        return serviceChargeMap.get(date);
    }
}
