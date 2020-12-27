package playground.clean.software.paymanager;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SalesReceiptTransaction implements Transaction {
    private final int empId;
    private final long date;
    private final double amount;

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getEmployee(empId);

        if (e == null) {
            throw new RuntimeException("No such employee");
        }

        if (!(e.getPaymentClassification() instanceof CommissionedClassification)) {
            throw new RuntimeException("Tried to add sales receipt to non-commissioned employee");
        }

        CommissionedClassification cc = (CommissionedClassification) e.getPaymentClassification();
        cc.addSalesReceipt(new SalesReceipt(date, amount));
    }
}
