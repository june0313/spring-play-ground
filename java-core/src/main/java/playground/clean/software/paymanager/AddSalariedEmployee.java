package playground.clean.software.paymanager;

public class AddSalariedEmployee extends AddEmployeeTransaction {
    private final double salary;

    public AddSalariedEmployee(int empId, String name, String address, double salary) {
        super(empId, name, address);
        this.salary = salary;
    }

    @Override
    protected PaymentSchedule getPaymentSchedule() {
        return new MonthlySchedule();
    }

    @Override
    protected PaymentClassification getClassification() {
        return new SalariedClassification(salary);
    }
}
