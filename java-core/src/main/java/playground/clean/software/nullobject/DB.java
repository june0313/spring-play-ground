package playground.clean.software.nullobject;

public class DB {
    public static Employee getEmployee(String name) {
        return Employee.NULL;
    }

    public static void main(String[] args) {
        Employee employee = DB.getEmployee("test");
        employee.pay();
    }
}
