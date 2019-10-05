package com.tavisca.gce.assignment.db;

import com.tavisca.gce.assignment.exception.DataSourceException;

import java.util.List;

public interface Dao {
    public List<?> findAll() throws DataSourceException;
    public void close() throws DataSourceException;
}
