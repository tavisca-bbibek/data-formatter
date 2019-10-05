package com.tavisca.gce.assignment.app;

import com.tavisca.gce.assignment.db.Dao;
import com.tavisca.gce.assignment.db.CustomerDao;
import com.tavisca.gce.assignment.exception.DataSourceException;
import com.tavisca.gce.assignment.serializer.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Dao dao;
        try {
            dao = new CustomerDao();
        } catch (DataSourceException e) {
            System.err.println("Error: " + e.getMessage());
            return;
        }

        List<?> allCustomers = null;
        try {
            allCustomers = dao.findAll();
        } catch (DataSourceException e) {
            System.out.println("Error: " + e.getMessage());
            Arrays.stream(e.getSuppressed())
                    .forEach(message -> System.out.println("Error: " + message + " - " ));
        }

        System.out.println("===========[ Your Data ]==========");
        for (Object customer : allCustomers) {
            System.out.println(customer);
        }

        System.out.println("Choose the data format: ");
        System.out.println("1. XML");
        System.out.println("2. JSON");
        System.out.println("3. CSV");
        System.out.println("Your input: ");

        Scanner scanner = new Scanner(System.in);
        int formatOption = Integer.parseInt(scanner.next());

        System.out.println("Enter the destination: ");
        String destination = scanner.next();

        Path destinationPath = Paths.get(destination);
        if (!Files.isDirectory(destinationPath)) {
            System.out.println("Not a good destination fella.");
            return;
        }

        Writer writer = null;
        switch (formatOption) {
            case 1:
                writer = new XMLWriter(destination + "/customers.xml");
                break;
            case 2:
                writer = new JsonWriter(destination + "/customers.json");
                break;
            case 3:
                writer = new CsvWriter(destination + "/customers.csv");
                break;
            default:
                System.out.println("Not a good choice fella.");
        }

        if(writer != null) {
            try {
                writer.writeList(allCustomers);
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
            System.out.println("Done!");
        }

        try {
            dao.close();
        } catch (DataSourceException e) {
            showError(e);
        }
    }

    private static void showError(DataSourceException e) {
        System.out.println("Error: " + e.getLocalizedMessage());
    }
}
