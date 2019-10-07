package com.tavisca.gce.assignment.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FormatDB {
    private static final String connection_URL = "jdbc:mysql://localhost:3306/formatdb";
    private static final String userName = "root";
    private static final String password = "root";
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null)
            connection = DriverManager.getConnection(connection_URL, userName, password);
        return connection;
    }
}
