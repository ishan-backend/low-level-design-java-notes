package designpatterns.solid.lsp.violation;

import java.util.List;

public class SalaryDisburser {
    public void disburseSalaries(List<Employee> employees) {
        for(int i=0; i<employees.size(); i++) {
            Employee employee = employees.get(i);
            // SalaryDisburser module has to know about concrete class Volunteer which are inheriting from abstract Employee, its implementation is distorted
            if(employee instanceof Volunteer) // you have to know about having Volunteer pre-known - relying on concretions also instead of just abstractions
                continue; // avoid handling exception

            employee.calcSalary();
        }
    }
}
