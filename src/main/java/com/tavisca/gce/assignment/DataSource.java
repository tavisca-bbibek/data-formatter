package com.tavisca.gce.assignment;

import com.tavisca.gce.assignment.exception.DataSourceException;

import java.util.List;

public interface DataSource {
    public List<?> findAll();
    public void close() throws DataSourceException;
}
