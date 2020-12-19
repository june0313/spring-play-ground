package playground.clean.software.paymanager;

public class AddHourlyEmployee extends AddEmployeeTransaction {
    private final double hourlyRate;

    public AddHourlyEmployee(int empId, String name, String address, double hourlyRate) {
        super(empId, name, address);
        this.hourlyRate = hourlyRate;
    }

    @Override
    protected PaymentSchedule getPaymentSchedule() {
        return new WeeklySchedule();
    }

    @Override
    protected PaymentClassification getClassification() {
        return new HourlyClassification(hourlyRate);
    }
}
