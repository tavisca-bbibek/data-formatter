package com.tavisca.gce.assignment.writer;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonWriter<T> implements Writer<T> {

    private final String fileName;

    public JsonWriter(String fileName) {
        this.fileName = fileName;
    }

    public void write(T[] elements) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper
                .writerWithDefaultPrettyPrinter()
                .writeValue(new File(fileName), elements);
    }

    public String getFileName() {
        return fileName;
    }
}
