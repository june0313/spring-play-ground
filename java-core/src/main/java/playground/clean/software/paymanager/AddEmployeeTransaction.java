package playground.clean.software.paymanager;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AddEmployeeTransaction implements Transaction {
    private final int empId;
    private final String name;
    private final String address;

    protected abstract PaymentSchedule getPaymentSchedule();
    protected abstract PaymentClassification getClassification();

    @Override
    public void execute() {
        PaymentClassification paymentClassification = getClassification();
        PaymentSchedule paymentSchedule = getPaymentSchedule();
        PaymentMethod paymentMethod = new HoldMethod();

        Employee employee = new Employee(empId, name, address);
        employee.setPaymentClassification(paymentClassification);
        employee.setPaymentSchedule(paymentSchedule);
        employee.setPaymentMethod(paymentMethod);

        PayrollDatabase.addEmployee(empId, employee);
    }
}
