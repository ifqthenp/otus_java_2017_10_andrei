package com.otus;

import com.otus.dataset.UserDataSet;
import com.otus.dbService.DBService;
import com.otus.dbService.DBServiceHibernateImp;

/**
 * {@code Main} class.
 */
public class Main
{
    public static void main(String[] args)
    {
        DBService dbService = new DBServiceHibernateImp();

        String status = dbService.getLocalStatus();
        System.out.println("Status: " + status);

        dbService.save(new UserDataSet("tully", 44));
        dbService.save(new UserDataSet("sully", 55));

        UserDataSet tully = dbService.load(1);
        UserDataSet sully = dbService.load(2);

        System.out.println(tully.getId() + " " + tully.getName() + " " + tully.getAge());
        System.out.println(sully.getId() + " " + sully.getName() + " " + sully.getAge());

        dbService.shutDown();
    }
}
