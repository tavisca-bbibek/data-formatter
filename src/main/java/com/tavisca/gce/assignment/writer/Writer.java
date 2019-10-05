package com.tavisca.gce.assignment.serializer;

import java.io.IOException;
import java.util.List;

public interface Writer<T> {
    public void writeList(List<T> list) throws IOException;
}
