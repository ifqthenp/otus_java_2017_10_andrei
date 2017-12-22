package com.otus.db_service;

import com.otus.dataset.DataSet;

import java.sql.SQLException;
import java.util.List;

public interface DBService extends AutoCloseable
{
    String getMetaData();

    void createTable() throws SQLException;

    void deleteTable() throws SQLException;

    <T extends DataSet> void saveUsersToDb(final List<T> users) throws Exception;

    <T extends DataSet> List<T> loadUsersFromDb(List<Integer> userIds, Class<T> cl) throws Exception;
}
