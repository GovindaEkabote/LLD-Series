package LLM.OOPS.Constructor;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    // 1. PRIVATE FIELDS - Encapsulation
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String department;
    private final double salary;
    private final List<String> skills;
    private final boolean isActive;

    // 2. Public CONSTRUCTOR
    public Employee(int id,String firstName, String lastName, String email, String department, double salary, List<String> skills,boolean isActive){
        this.id = id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.department=department;
        this.salary=salary;
        this.skills=skills;
        this.isActive=isActive;

        validateEmployee();  // Validation in constructor
    }

    // 3. VALIDATION METHOD
    private void  validateEmployee(){
        if (firstName == null || firstName.trim().isEmpty()){
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
    }

    // 4. GETTERS
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public List<String> getSkills() {
        return skills;
    }

    public boolean isActive() {
        return isActive;
    }
}
