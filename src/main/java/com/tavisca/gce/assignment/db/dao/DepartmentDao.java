package com.tavisca.gce.assignment.db.dao;

import com.tavisca.gce.assignment.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao extends  Dao<Department>{

    public DepartmentDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Department> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        String readAllQuery = "SELECT * FROM department;";
        ResultSet departmentSet = statement.executeQuery(readAllQuery);

        List<Department> departments = new ArrayList<>();
        while(departmentSet.next()){
            Department department = new Department(
                    departmentSet.getInt("id"),
                    departmentSet.getString("name")
            );
            departments.add(department);
        }
        return  departments;
    }

    @Override
    public Department findById(int id) throws SQLException {
        String readForIdQuery = "SELECT * FROM department WHERE id=?;";
        PreparedStatement statement = connection.prepareStatement(readForIdQuery);
        statement.setInt(1, id);

        ResultSet departmentSet = statement.executeQuery();
        departmentSet.next();
        return new Department(
                departmentSet.getInt("id"),
                departmentSet.getString("name")
        );
    }
}
