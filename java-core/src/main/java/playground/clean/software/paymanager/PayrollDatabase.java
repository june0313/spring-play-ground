package playground.clean.software.paymanager;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {
    private static final Map<Integer, Employee> employeeMap = new HashMap<>();

    public static Employee getEmployee(int empId) {
        return employeeMap.get(empId);
    }

    public static void addEmployee(int empId, Employee employee) {
        employeeMap.put(empId, employee);
    }

    public static void deleteEmployee(int empId) {
        employeeMap.remove(empId);
    }
}
