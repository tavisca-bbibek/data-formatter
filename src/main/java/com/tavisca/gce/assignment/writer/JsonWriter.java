package com.tavisca.gce.assignment.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tavisca.gce.assignment.Customer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonWriter implements Writer {

    private final String fileName;

    public JsonWriter(String fileName) {
        this.fileName = fileName;
    }

    public void writeList(List<?> list) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper
                .writerWithDefaultPrettyPrinter()
                .writeValue(new File(fileName), list);
    }

    public String getFileName() {
        return fileName;
    }
}
