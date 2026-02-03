package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ems.model.Employee;
import com.ems.util.DBConnection;

public class EmployeeDAO {

    // ADD EMPLOYEE
    public boolean addEmployee(Employee emp) {

        boolean status = false;

        String sql = "INSERT INTO employee " +
                "(name, department, role, salary, email, phone) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setString(3, emp.getRole());
            ps.setDouble(4, emp.getSalary());
            ps.setString(5, emp.getEmail());
            ps.setString(6, emp.getPhone());

            int rows = ps.executeUpdate();
            status = rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // VIEW ALL EMPLOYEES
    public List<Employee> getAllEmployees() {

        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Employee emp = new Employee();

                emp.setEmpId(rs.getInt("emp_id"));
                emp.setName(rs.getString("name"));
                emp.setDepartment(rs.getString("department"));
                emp.setRole(rs.getString("role"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setEmail(rs.getString("email"));
                emp.setPhone(rs.getString("phone"));

                list.add(emp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
