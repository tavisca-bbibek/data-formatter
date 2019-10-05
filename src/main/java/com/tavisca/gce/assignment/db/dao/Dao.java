package com.tavisca.gce.assignment.db;

import com.tavisca.gce.assignment.exception.DataSourceException;

import java.util.List;

public interface Dao<T> {
    public List<T> findAll() throws DataSourceException;
    public void close() throws DataSourceException;
}
