package com.otus.db_service;

import com.otus.connection.ConnectionHelper;
import com.otus.dataset.DataSet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBServiceConnection implements DBService
{
    private final Connection connection;

    DBServiceConnection()
    {
        connection = ConnectionHelper.getConnection();
    }

    @Override
    public String getMetaData()
    {
        try {
            return "Connected to: " + getConnection().getMetaData().getURL() + "\n" +
                "DB name: " + getConnection().getMetaData().getDatabaseProductName() + "\n" +
                "DB version: " + getConnection().getMetaData().getDatabaseProductVersion() + "\n" +
                "Driver: " + getConnection().getMetaData().getDriverName();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public void createTable() throws SQLException {}

    @Override
    public void deleteTable() throws SQLException {}

    @Override
    public <T extends DataSet> void saveUsersToDb(final List<T> users) throws Exception {}

    @Override
    public <T extends DataSet> List<T> loadUsersFromDb(final List<Integer> idList, final Class<T> cl) throws Exception
    {
        return null;
    }

    @Override
    public void close() throws Exception
    {
        connection.close();
    }

    protected Connection getConnection()
    {
        return connection;
    }
}
