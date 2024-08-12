package employee_payroll_oop;

import java.util.ArrayList;

abstract class Employee{
    private int id;
    private String name;

    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }

    public abstract double calculateSalary();
    public String toString(){
        return "Employee [name : "+name+ " id : "+id+" salary : "+calculateSalary() +"]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(int id, String name, double monthlySalary){
        super(id, name);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hourWorked;
    private int hourRate;

    public PartTimeEmployee(int id, String name, int hourRate, int hourWorked){
        super(id, name);
        this.hourRate = hourRate;
        this.hourWorked = hourWorked;
    }
    @Override
    public double calculateSalary() {
        return hourWorked * hourRate;
    }
}

class PayrollSystem {
    private ArrayList<Employee> employeeList;
    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;

        for (Employee employee:employeeList) {
            if(employee.getId() == id){
                employeeToRemove = employee;
                break;
            }

        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
            System.out.println("Employee removed with id: "+id);
        } else {
            System.out.println("Employee not found with id: "+id);
        }
    }
    public void displayAllEmployee(){
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}
public class Main {
    public static void main(String[] args) {

        PayrollSystem payrollSystem = new PayrollSystem();

        FullTimeEmployee fullTimeEmployee1 = new FullTimeEmployee(1, "Bibek", 70000.00);
        FullTimeEmployee fullTimeEmployee2 = new FullTimeEmployee(2, "Kumar", 98000.00);

        PartTimeEmployee partTimeEmployee1 = new PartTimeEmployee(3, "Ayush", 550, 145);
        PartTimeEmployee partTimeEmployee2 = new PartTimeEmployee(4, "Pramod", 660, 125);

        payrollSystem.addEmployee(fullTimeEmployee1);
        payrollSystem.addEmployee(fullTimeEmployee2);
        payrollSystem.addEmployee(partTimeEmployee1);
        payrollSystem.addEmployee(partTimeEmployee2);

        System.out.println("\n*********** ALL EMPLOYEE ************");
        payrollSystem.displayAllEmployee();

        System.out.println("\n*********** REMOVE EMPLOYEE ************");
        payrollSystem.removeEmployee(5);

        System.out.println("\n*********** ALL EMPLOYEE ************");
        payrollSystem.displayAllEmployee();
    }
}
