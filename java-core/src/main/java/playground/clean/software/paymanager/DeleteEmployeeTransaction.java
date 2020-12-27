package playground.clean.software.paymanager;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteEmployeeTransaction implements Transaction {
    private int empId;

    @Override
    public void execute() {
        PayrollDatabase.deleteEmployee(empId);
    }
}
