package com.otus.dbService;

import com.otus.dataset.UserDataSet;

public interface DBService
{
    String getLocalStatus();

    void save(final UserDataSet user);

    UserDataSet load(long id);

    void shutDown();
}
