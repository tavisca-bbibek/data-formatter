package com.tavisca.gce.assignment.db.dao;

import com.tavisca.gce.assignment.model.Customer;
import com.tavisca.gce.assignment.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao extends Dao<Customer> {

    public CustomerDao(Connection connection) {
        super(connection);
    }

    public List<Customer> findAll() throws SQLException {
        final String readAllQuery = "SELECT * FROM customers;";
        List<Customer> customers = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet customerSet = statement.executeQuery(readAllQuery);

        while (customerSet.next()) {
            Customer customer = new Customer(
                    customerSet.getInt("id"),
                    customerSet.getString("first_name"),
                    customerSet.getString("last_name"),
                    customerSet.getString("contact"),
                    customerSet.getString("address")
            );
            customers.add(customer);
        }

        return customers;
    }

    @Override
    public Customer findById(int id) throws SQLException {
        String readForIdQuery = "SELECT * FROM customers WHERE id=?;";
        PreparedStatement statement = connection.prepareStatement(readForIdQuery);
        statement.setInt(1, id);

        ResultSet customerSet = statement.executeQuery();
        customerSet.next();
        return new Customer(
                customerSet.getInt("id"),
                customerSet.getString("first_name"),
                customerSet.getString("last_name"),
                customerSet.getString("contact"),
                customerSet.getString("address")
        );
    }

}
