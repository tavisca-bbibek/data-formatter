package com.tavisca.gce.assignment.db.dao;

import com.tavisca.gce.assignment.model.Department;
import com.tavisca.gce.assignment.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao extends Dao<Employee>{

    public EmployeeDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Employee> findAll() throws SQLException {
        final String readAllQuery = "SELECT * FROM employee;";
        List<Employee> employees = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet employeeSet = statement.executeQuery(readAllQuery);

        while (employeeSet.next()) {
            Employee customer = new Employee(
                    employeeSet.getInt("empid"),
                    employeeSet.getString("name"),
                    extractHobbies(employeeSet.getString("hobbies")),
                    findDepartment(employeeSet.getInt("department"))
            );
            employees.add(customer);
        }

        return employees;
    }

    private Department findDepartment(int id) throws SQLException {
        return new DepartmentDao(this.connection)
                .findById(id);
    }

    private String[] extractHobbies(String hobbies) {
        return hobbies.split(", *");
    }

    @Override
    public Employee findById(int id) throws SQLException {
        String readForIdQuery = "SELECT * FROM employee WHERE id=?;";
        PreparedStatement statement = connection.prepareStatement(readForIdQuery);
        statement.setInt(1, id);

        ResultSet employeeSet = statement.executeQuery();
        employeeSet.next();
        return new Employee(
                employeeSet.getInt("empid"),
                employeeSet.getString("name"),
                extractHobbies(employeeSet.getString("hobbies")),
                findDepartment(employeeSet.getInt("department"))
                );
    }
}
