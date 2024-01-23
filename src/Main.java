import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int Id;
    private String location;

//    public Employee() {};

    public Employee(String name, int Id, String location) {
        this.name = name;
        this.Id = Id;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return Id;
    }

    public String getLocation() {
        return location;
    }

    abstract public double calculateSalary();

    @Override
    public String toString() {
        return "Employee: \nId: " + Id + "\nName: "+ name + "\nLocation: " + location + "\nSalary: " +  calculateSalary() + "\n";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, String location, double monthlySalary) {
        super(name, id, location);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private double salaryPerHour;
    private int duration;

    public PartTimeEmployee(String name, int id, String location, double salaryPerHour, int duration) {
        super(name, id, location);
        this.salaryPerHour = salaryPerHour;
        this.duration = duration;
    }

    @Override
    public double calculateSalary() {
        return salaryPerHour * duration;
    }
}

class PayrollSystem {
    ArrayList<Employee> employees;

    public PayrollSystem() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(int Id) {
        Employee removedEmployee = null;

        for (Employee emp: employees) {
            if(emp.getId() == Id) {
                removedEmployee = emp;
                break;
            }
        }

        if(removedEmployee != null) {
            employees.remove(removedEmployee);
        }
    }

    public void displayEmployee() {
        for (Employee emp: employees) {
            System.out.println(emp);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        FullTimeEmployee fEmp1 = new FullTimeEmployee("Raju Gunnam", 001, "Hyderabad, IN", 78000.00);
        FullTimeEmployee fEmp2 = new FullTimeEmployee("Hemant Kumar", 002, "Mumbai, IN", 74000.00);
        PartTimeEmployee pEmp3 = new PartTimeEmployee("Pooja Padhre", 003, "Mumbai, IN", 200.00, 60);

        payrollSystem.addEmployee(fEmp1);
        payrollSystem.addEmployee(fEmp2);
        payrollSystem.addEmployee(pEmp3);

        System.out.println("All Employee Details: ");
        payrollSystem.displayEmployee();

        System.out.println("Removed 002 Employee: ");
        payrollSystem.removeEmployee(002);

        System.out.println("Remaining Employee Details: ");
        payrollSystem.displayEmployee();
        return;
    }
}