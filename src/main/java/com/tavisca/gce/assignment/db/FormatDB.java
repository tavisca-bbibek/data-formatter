package com.tavisca.gce.assignment.db;

import com.tavisca.gce.assignment.exception.DataSourceException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FormatDB {
    private static final String connection_URL = "jdbc:mysql://localhost:3306/formatdb";
    private static final String userName = "root";
    private static final String password = "root";

    private static FormatDB instance = null;
    private Connection connection;

    private FormatDB() {
    }

    static FormatDB getInstance() {
        if (instance == null)
            instance = new FormatDB();
        return instance;
    }

    Connection getConnection() throws DataSourceException {
        if (connection != null)
            return connection;
        try {
            connection = DriverManager.getConnection(connection_URL, userName, password);
            return connection;
        } catch (SQLException e) {
            throw new DataSourceException("Can't connect to the Mysql server", e);
        }
    }
}
