package com.ems.main;

import java.util.List;
import java.util.Scanner;

import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;

public class EmployeeApp {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Role: ");
                    String role = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    Employee emp = new Employee(
                            0, name, dept, role, salary, email, phone
                    );

                    boolean added = dao.addEmployee(emp);

                    if (added) {
                        System.out.println("✅ Employee Added Successfully");
                    } else {
                        System.out.println("❌ Failed to Add Employee");
                    }
                    break;

                case 2:
                    List<Employee> employees = dao.getAllEmployees();

                    System.out.println("\n--- Employee List ---");
                    for (Employee e : employees) {
                        System.out.println(
                                e.getEmpId() + " | " +
                                        e.getName() + " | " +
                                        e.getDepartment() + " | " +
                                        e.getRole() + " | " +
                                        e.getSalary()
                        );
                    }
                    break;

                case 3:
                    System.out.println("👋 Exiting Application");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("⚠️ Invalid Choice");
            }
        }
    }
}
