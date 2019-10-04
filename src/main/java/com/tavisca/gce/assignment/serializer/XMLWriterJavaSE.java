package com.tavisca.gce.assignment.serializer;

import java.beans.XMLEncoder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class XMLWriterJavaSE implements Writer{

    private final String fileName;

    public XMLWriterJavaSE(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeList(List<?> list) throws IOException {
        Path filePath = Paths.get(fileName);
        XMLEncoder encoder = new XMLEncoder(Files.newOutputStream(filePath));
        encoder.writeObject(list.toArray());
        encoder.flush();
        encoder.close();
    }
}
