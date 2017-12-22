package com.otus;

import com.otus.dataset.DataSet;
import com.otus.dataset.UserDataSet;
import com.otus.db_service.DBService;
import com.otus.db_service.DBServiceUpdate;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code Main} class.
 */
public class Main
{
    public static void main(String[] args) throws Exception
    {
        dropTable();
        createTable();

        DBService dbService = new DBServiceUpdate();

        List<UserDataSet> users = new ArrayList<>();
        users.add(new UserDataSet("Harry Hacker", 21));
        users.add(new UserDataSet("Carl Cracker", 18));
        users.add(new UserDataSet("Tony Tester", 25));

        dbService.saveUsersToDb(users);

        List<Integer> ids = new ArrayList<>();
        ids.add(9);
        ids.add(0);
        ids.add(3);
        ids.add(4);
        ids.add(1);
        ids.add(2);

        List<? extends DataSet> loadedUsers = dbService.loadUsersFromDb(ids, UserDataSet.class);
        System.out.println("Users loaded from database: " + loadedUsers);
    }

    private static void createTable() throws Exception
    {
        try (DBServiceUpdate dbService = new DBServiceUpdate()) {
            System.out.println(dbService.getMetaData());
            dbService.createTable();
        }
    }

    private static void dropTable() throws Exception
    {
        try (DBServiceUpdate dbService = new DBServiceUpdate()) {
            dbService.deleteTable();
        }
    }
}
