package com.kainos.ea.service;

import com.kainos.ea.ConnectionDB;
import com.kainos.ea.dao.EmployeeDao;
import com.kainos.ea.model.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    public List<Employee> getAllEmployees() throws SQLException{
        EmployeeDao dao = new EmployeeDao();

        return dao.selectAllEmployees(ConnectionDB.getConnection());
    }

    public Employee getEmployeeByID(int employeeID) throws SQLException{
        EmployeeDao dao = new EmployeeDao();

        return dao.selectEmployeeByID(employeeID, ConnectionDB.getConnection());
    }

    public Employee getEmployeeByName(String employeeName) throws SQLException{
        EmployeeDao dao = new EmployeeDao();

        return dao.selectEmployeeByName(employeeName, ConnectionDB.getConnection());
    }
}
