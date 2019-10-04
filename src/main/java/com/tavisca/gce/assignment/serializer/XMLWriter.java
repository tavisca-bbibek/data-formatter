package com.tavisca.gce.assignment.serializer;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.tavisca.gce.assignment.Customer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLWriter implements Writer {

    private final String fileName;

    public XMLWriter(String fileName) {
        this.fileName = fileName;
    }

    public void writeList(List<?> list) throws IOException {
        XmlMapper mapper = new XmlMapper();
        mapper.writeValue(new File(fileName), list);
    }

    public String getFileName() {
        return fileName;
    }
}
