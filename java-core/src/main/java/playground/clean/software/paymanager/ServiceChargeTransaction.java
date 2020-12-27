package playground.clean.software.paymanager;

public class ServiceChargeTransaction implements Transaction {
    private int memberId;
    private long date;
    private double charge;

    public ServiceChargeTransaction(int memberId, long date, double charge) {
        this.memberId = memberId;
        this.date = date;
        this.charge = charge;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getUnionMember(memberId);
        Affiliation af = e.getAffiliation();

        if (af instanceof UnionAffiliation) {
            UnionAffiliation uaf = (UnionAffiliation) af;
            uaf.addServiceCharge(date, charge);
        }
    }
}
