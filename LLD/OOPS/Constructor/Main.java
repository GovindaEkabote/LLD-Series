package LLM.OOPS.Constructor;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee(
                101,
                "Govinda",
                "Ekabote",
                "govinda@gmail.com",
                "Engineering",
                75000.0,
                Arrays.asList("Java", "Spring", "SQL"),
                true
        );
        System.out.println("ID: " + employee.getId());
        System.out.println("First Name: " + employee.getFirstName());
        System.out.println("Last Name: " + employee.getLastName());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("Salary: " + employee.getSalary());
        System.out.println("Skills: " + employee.getSkills());
        System.out.println("Active: " + employee.isActive());

    }
}
