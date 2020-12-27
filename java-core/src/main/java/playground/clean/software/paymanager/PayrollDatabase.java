package playground.clean.software.paymanager;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {
    private static final Map<Integer, Employee> employeeMap = new HashMap<>();
    private static final Map<Integer, Employee> unionMemberMap = new HashMap<>();

    public static Employee getEmployee(int empId) {
        return employeeMap.get(empId);
    }

    public static void addEmployee(int empId, Employee employee) {
        employeeMap.put(empId, employee);
    }

    public static void deleteEmployee(int empId) {
        employeeMap.remove(empId);
    }

    public static Employee getUnionMember(int memberId) {
        return unionMemberMap.get(memberId);
    }

    public static void addUnionMember(int memberId, Employee e) {
        unionMemberMap.put(memberId, e);
    }
}
