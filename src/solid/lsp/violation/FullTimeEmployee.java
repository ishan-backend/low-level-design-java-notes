package solid.lsp.violation;

public class FullTimeEmployee extends Employee {

    protected FullTimeEmployee(int employeeId) {
        super(employeeId);
    }

    @Override
    protected double calcSalary(){
        System.out.println("Calculating full-time employee salary");
        return 0;
    }
}
