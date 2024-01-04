package designpatterns.solid.lsp.violation;

import java.util.ArrayList;
import java.util.List;

public class DisburseSalarySimulator {
    public static void main(String []args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee(1));
        employees.add(new FullTimeEmployee(2));
        employees.add(new Volunteer(3)); // doing substitution of subclass in base class, then some kind of handling for exception is required in New Module (SalaryDisburser)
        employees.add(new Volunteer(4));

        SalaryDisburser salaryDisburser = new SalaryDisburser();
        salaryDisburser.disburseSalaries(employees);
    }
}
