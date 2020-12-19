package playground.clean.software.paymanager;

public class AddCommissionedEmployee extends AddEmployeeTransaction {
    private final double salary;
    private final double commissionRate;

    public AddCommissionedEmployee(int empId, String name, String address, double salary, double commissionRate) {
        super(empId, name, address);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    protected PaymentSchedule getPaymentSchedule() {
        return new BiweeklySchedule();
    }

    @Override
    protected PaymentClassification getClassification() {
        return new CommissionedClassification(salary, commissionRate);
    }
}
