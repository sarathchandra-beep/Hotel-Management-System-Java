package com.ems.model;

public class Employee {

    private int empId;
    private String name;
    private String department;
    private String role;
    private double salary;
    private String email;
    private String phone;

    // Default Constructor
    public Employee() {
    }

    // Parameterized Constructor
    public Employee(int empId, String name, String department,
                    String role, double salary,
                    String email, String phone) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.email = email;
        this.phone = phone;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
