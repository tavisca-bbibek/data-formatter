package com.tavisca.gce.assignment.app;

import com.tavisca.gce.assignment.DataSource;
import com.tavisca.gce.assignment.MysqlDataSource;
import com.tavisca.gce.assignment.exception.DataSourceException;
import com.tavisca.gce.assignment.serializer.CsvWriter;
import com.tavisca.gce.assignment.serializer.JsonWriter;
import com.tavisca.gce.assignment.serializer.Writer;
import com.tavisca.gce.assignment.serializer.XMLWriterJavaSE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        DataSource dataSource;
        try {
            dataSource = new MysqlDataSource();
        } catch (DataSourceException e) {
            System.err.println("Error: " + e.getMessage());
            return;
        }

        List<?> allCustomers = dataSource.findAll();

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
                writer = new XMLWriterJavaSE(destination + "/customers.xml");
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
            dataSource.close();
        } catch (DataSourceException e) {
            showError(e);
        }
    }

    private static void showError(DataSourceException e) {
        System.out.println("Error: " + e.getLocalizedMessage());
    }
}
