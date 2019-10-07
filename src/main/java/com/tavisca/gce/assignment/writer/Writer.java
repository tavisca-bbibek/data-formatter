package com.tavisca.gce.assignment.writer;

import java.io.IOException;
import java.util.List;

public interface Writer<T> {
    void write(T[] list) throws IOException;
}
