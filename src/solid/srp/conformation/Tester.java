package solid.srp.conformation;

public class Tester {

    public static void main(String []args) {
        Employee e = new Employee(1);
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        PerformanceReportPrinter perfReportPrinter = new PerformanceReportPrinter();
        BioDataRetreiver bioDataRetreiver = new BioDataRetreiver();
        System.out.println(salaryCalculator.CalcSalary(e));
        System.out.println(perfReportPrinter.printPerformanceReport(e));
        System.out.println(bioDataRetreiver.getBioData(e));
    }
}
