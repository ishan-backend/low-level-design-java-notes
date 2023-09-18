package solid.srp.violation;

import solid.common.BioData;

public class Employee {
    private final int employeeId;

    public Employee(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    // Calculate Salary
    public double calculateSalary() {
        return 0;
    }

    // Print performance report
    public String printPerformanceReport() {
        return "";
    }

    // Retrieves data
    public BioData retrieveBioData() {
        BioData biodata = null;
        return biodata;
    }
}
