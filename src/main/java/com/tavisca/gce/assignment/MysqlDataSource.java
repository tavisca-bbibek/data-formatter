package com.tavisca.gce.assignment;

import com.tavisca.gce.assignment.exception.DataSourceException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlDataSource implements DataSource{
    private static final String connection_URL = "jdbc:mysql://localhost:3306/formatdb";
    private static final String userName = "root";
    private static final String password = "root";

    private Connection connection;

    public MysqlDataSource() throws DataSourceException {
        try {
            connection = DriverManager.getConnection(connection_URL, userName, password);
        } catch (SQLException e) {
            throw new DataSourceException("Can't connect to the Mysql server");
        }
    }

    public List <Customer> findAll() {
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
            e.printStackTrace();
        }

        return idToCustomerMap;
    }

    public void close() throws DataSourceException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DataSourceException("Can't close the database connection");
        }
    }
}
