package com.tavisca.gce.assignment.db.dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class Dao<T> {

    protected Connection connection;

    public Dao(Connection connection) {
        this.connection = connection;
    }

    public abstract List<T> findAll() throws SQLException;

    public abstract T findById(int id) throws SQLException;
}
