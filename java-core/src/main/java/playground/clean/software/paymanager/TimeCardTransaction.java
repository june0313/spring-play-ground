package playground.clean.software.paymanager;

public class TimeCardTransaction implements Transaction {
    private int empId;
    private long date;
    private double hours;

    public TimeCardTransaction(int empId, long date, double hours) {
        this.empId = empId;
        this.date = date;
        this.hours = hours;
    }

    @Override
    public void execute() {
        Employee employee = PayrollDatabase.getEmployee(empId);
        if (employee != null) {
            PaymentClassification pc = employee.getPaymentClassification();

            if (pc instanceof HourlyClassification) {
                HourlyClassification hc = (HourlyClassification) pc;
                hc.addTimeCard(new TimeCard(date, hours));
            } else {
                throw new RuntimeException("Tried to add time card to non-hourly employee");
            }
        } else {
            throw new RuntimeException("No such employee");
        }
    }
}
