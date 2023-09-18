package solid.lsp.violation;

// protected - we want them to be shared only amongst subclasses
public abstract class Employee {
    protected final int employeeId;

    protected Employee(int employeeId) {
        this.employeeId = employeeId;
    }

    protected abstract double calcSalary();
}
