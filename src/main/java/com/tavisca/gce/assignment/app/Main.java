package com.tavisca.gce.assignment.app;

import com.tavisca.gce.assignment.db.dao.EmployeeDao;
import com.tavisca.gce.assignment.model.Customer;
import com.tavisca.gce.assignment.db.FormatDB;
import com.tavisca.gce.assignment.db.dao.Dao;
import com.tavisca.gce.assignment.model.Employee;
import com.tavisca.gce.assignment.writer.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection formatDBConnection = null;
        try {
            formatDBConnection = FormatDB.getConnection();
        } catch (SQLException e) {
            showError(e);
        }

        Dao employeeDao = new EmployeeDao(formatDBConnection);
        List<Employee> employees = null;
        try {
            employees = employeeDao.findAll();
        } catch (SQLException e) {
            System.err.println("Error: query execution failed");
        }

        System.out.println("===========[ Save Your Data ]==========");
        employees.forEach(System.out::println);
        System.out.println("Formats available: ");
        System.out.println("1. XML");
        System.out.println("2. JSON");
        System.out.println("3. CSV");
        System.out.println("Your choice: ");

        Scanner scanner = new Scanner(System.in);
        int formatOption = Integer.parseInt(scanner.next());

        System.out.println("Destination folder: ");
        String destination = scanner.next();

        Path destinationPath = Paths.get(destination);
        if (!Files.isDirectory(destinationPath)) {
            System.out.println("Not a good destination fella.");
            return;
        }

        Writer writer = null;
        switch (formatOption) {
            case 1:
                writer = new XMLWriter<Customer>(destination + "/customers.xml");
                break;
            case 2:
                writer = new JsonWriter<Customer>(destination + "/customers.json");
                break;
            case 3:
                writer = new CsvWriter<Customer>(destination + "/customers.csv");
                break;
            default:
                System.out.println("Not a good choice fella.");
        }

        if (writer != null) {
            try {
                writer.write(employees.toArray(new Employee[0]));
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
            System.out.println("Done!");
        }

        try {
            formatDBConnection.close();
        } catch (SQLException e) {
            showError(e);
        }
    }

    private static void showError(Throwable e) {
        System.out.println("Error: " + e.getMessage());
        Arrays.stream(e.getSuppressed())
                .forEach(message -> System.out.println("Error: " + message + " - "));
    }
}
