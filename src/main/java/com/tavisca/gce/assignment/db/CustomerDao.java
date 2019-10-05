package com.tavisca.gce.assignment.db;

import com.tavisca.gce.assignment.Customer;
import com.tavisca.gce.assignment.exception.DataSourceException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements Dao {


    private Connection connection;

    public CustomerDao() throws DataSourceException {
        connection = FormatDB.getInstance().getConnection();
    }

    public List <Customer> findAll() throws DataSourceException {
        final String readAllQuery = "SELECT * FROM customers;";
        List<Customer> idToCustomerMap = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet customerSet = statement.executeQuery(readAllQuery);

            while (customerSet.next()) {
                Customer customer = new Customer(
                        customerSet.getInt(1),
                        customerSet.getString(2),
                        customerSet.getString(3),
                        customerSet.getString(4),
                        customerSet.getString(5)
                );
                idToCustomerMap.add(customer);
            }
        } catch (SQLException e) {
           throw new DataSourceException("invalid result set", e);
        }

        return idToCustomerMap;
    }

    public void close() throws DataSourceException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DataSourceException("Can't close the database connection", e);
        }
    }
}
