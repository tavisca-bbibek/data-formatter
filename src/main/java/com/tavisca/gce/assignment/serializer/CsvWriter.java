package com.tavisca.gce.assignment.serializer;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.tavisca.gce.assignment.Customer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CsvWriter implements Writer {

    private final String fileName;

    public CsvWriter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeList(List<?> list) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = csvMapper.schemaFor(Customer.class);
        csvMapper
                .writer(schema)
                .writeValue(new File(fileName), list);
    }

    public String getFileName() {
        return fileName;
    }

}
