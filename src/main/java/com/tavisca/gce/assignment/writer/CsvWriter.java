package com.tavisca.gce.assignment.writer;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.tavisca.gce.assignment.model.Employee;

import java.io.File;
import java.io.IOException;

public class CsvWriter<T> implements Writer<T> {

    private final String fileName;

    public CsvWriter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(T[] elements) throws IOException {
        if (elements == null || elements.length == 0)
            return;

        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = csvMapper.schemaFor(elements[0].getClass());
        csvMapper
                .writer(schema)
                .writeValue(new File(fileName), elements);
    }

    public String getFileName() {
        return fileName;
    }

}
