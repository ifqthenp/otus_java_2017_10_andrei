package com.otus.dbService;

import com.otus.entities.UserDataSet;

import java.util.List;

/**
 * @author v.chibrikov
 */
public interface DBService
{
    String getLocalStatus();

    void save(UserDataSet dataSet);

    UserDataSet read(long id);

    UserDataSet readByName(String name);

    List<UserDataSet> readAll();

    void shutdown();
}
