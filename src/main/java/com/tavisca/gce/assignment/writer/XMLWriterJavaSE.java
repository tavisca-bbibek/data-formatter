package com.tavisca.gce.assignment.writer;

import java.beans.XMLEncoder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class XMLWriterJavaSE<T> implements Writer<T>{

    private final String fileName;

    public XMLWriterJavaSE(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(T[] elements) throws IOException {
        Path filePath = Paths.get(fileName);
        XMLEncoder encoder = new XMLEncoder(Files.newOutputStream(filePath));
        encoder.writeObject(elements);
        encoder.flush();
        encoder.close();
    }
}
