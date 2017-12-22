package com.otus.db_service;

import com.otus.dataset.DataSet;
import com.otus.executor.TExecutor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DBServiceUpdate extends DBServiceConnection
{
    private static final String CREATE_TABLE_DATA_SET = "CREATE TABLE IF NOT EXISTS" +
        " UserDataSet (id BIGINT(20) NOT NULL AUTO_INCREMENT, name VARCHAR(255), age INT(3), PRIMARY KEY(id))";
    private static final String DELETE_TABLE_DATA_SET = "DROP TABLE IF EXISTS UserDataSet";

    @Override
    public void createTable() throws SQLException
    {
        Connection conn = getConnection();
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(CREATE_TABLE_DATA_SET);
        }
        System.out.println("Table created.");
    }

    @Override
    public <T extends DataSet> void saveUsersToDb(final List<T> users) throws Exception
    {
        try (TExecutor tExec = new TExecutor()) {
            for (T user : users) {
                tExec.save(user);
            }
        }
    }

    @Override
    public <T extends DataSet> List<T> loadUsersFromDb(List<Integer> userIds, Class<T> cl) throws Exception
    {
        List<T> result = new ArrayList<>();
        for (Integer id : userIds) {
            try (TExecutor tExec = new TExecutor()) {
                T o = tExec.load(id, cl);
                if (o != null) {
                    result.add(o);
                }
            }
        }
        return result;
    }

    @Override
    public void deleteTable() throws SQLException
    {
        Connection conn = getConnection();
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(DELETE_TABLE_DATA_SET);
        }
        System.out.println("Table dropped.");
    }
}
