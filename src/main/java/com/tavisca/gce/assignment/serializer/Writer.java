package com.tavisca.gce.assignment.serializer;

import java.io.IOException;
import java.util.List;

public interface Writer {
    public void writeList(List<?> list) throws IOException;
}
