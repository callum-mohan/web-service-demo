package com.kainos.ea.dao;

import com.kainos.ea.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public void insertEmployee(Employee emp, Connection c) throws SQLException {
        Statement st = c.createStatement();
        String insertEmployeeQuery = "INSERT INTO Employee VALUES (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStmt = c.prepareStatement(insertEmployeeQuery);
        preparedStmt.setInt(1, emp.getID());
        preparedStmt.setString(2, emp.getName());
        preparedStmt.setInt(3, emp.getSalary());
        preparedStmt.setString(4, emp.getBankNo());
        preparedStmt.setString(5, emp.getNIN());
        preparedStmt.setString(6, emp.getPhoneNumber());
        preparedStmt.setString(7, emp.getCountryCode());
        preparedStmt.executeUpdate();
    }

    public List<Employee> selectAllEmployees(Connection c) throws SQLException{
        List<Employee> allEmployees = new ArrayList<>();
        Statement st = c.createStatement();
        String selectLastEmployee = "SELECT * FROM Employee";
        PreparedStatement preparedStmt = c.prepareStatement(selectLastEmployee);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            Employee dbEmp = new Employee(rs.getInt("EmployeeID"),
                    rs.getString("EmployeeName"), rs.getInt("Salary"), rs.getString("BankNo"),
                    rs.getString("NIN"), rs.getString("EmployeePhoneNo"), rs.getString("EmployeeCountryCode"));
            allEmployees.add(dbEmp);
        }
        return allEmployees;
    }

    public Employee selectEmployeeByID(int id, Connection c) throws SQLException{
        Employee dbEmp = new Employee();
        Statement st = c.createStatement();
        String selectEmployeeByID = "SELECT * FROM Employee WHERE EmployeeID = ?";
        PreparedStatement preparedStmt = c.prepareStatement(selectEmployeeByID);
        preparedStmt.setInt(1, id);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            dbEmp = new Employee(rs.getInt("EmployeeID"),
                    rs.getString("EmployeeName"), rs.getInt("Salary"), rs.getString("BankNo"),
                    rs.getString("NIN"), rs.getString("EmployeePhoneNo"), rs.getString("EmployeeCountryCode"));
        }
        return dbEmp;
    }

    public Employee selectEmployeeByName(String name, Connection c) throws SQLException{
        Employee dbEmp = new Employee();
        Statement st = c.createStatement();
        String selectEmployeeByName = "SELECT * FROM Employee WHERE EmployeeName = ?";
        PreparedStatement preparedStmt = c.prepareStatement(selectEmployeeByName);
        preparedStmt.setString(1, name);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            dbEmp = new Employee(rs.getInt("EmployeeID"),
                    rs.getString("EmployeeName"), rs.getInt("Salary"), rs.getString("BankNo"),
                    rs.getString("NIN"), rs.getString("EmployeePhoneNo"), rs.getString("EmployeeCountryCode"));
        }
        return dbEmp;
    }
}
