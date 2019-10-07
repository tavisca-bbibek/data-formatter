package com.tavisca.gce.assignment.writer;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLWriter<T> implements Writer<T> {

    private final String fileName;

    public XMLWriter(String fileName) {
        this.fileName = fileName;
    }

    public void write(T[] elements) throws IOException {
        XmlMapper mapper = new XmlMapper();
//        mapper
//                .writerWithDefaultPrettyPrinter()
//                .writeValue(new File(fileName), elements);
        String xml="";
        for(T element : elements){
            xml += mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(element);
        }
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(xml);
        fileWriter.close();
    }

    public String getFileName() {
        return fileName;
    }
}
