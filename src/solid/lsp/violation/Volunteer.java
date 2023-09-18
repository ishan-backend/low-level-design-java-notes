package solid.lsp.violation;

public class Volunteer extends Employee{
    protected Volunteer(int employeeId) {
        super(employeeId);
    }

    @Override
    protected double calcSalary() {
        throw new RuntimeException("volunteers don't draw salary");
    }
}
