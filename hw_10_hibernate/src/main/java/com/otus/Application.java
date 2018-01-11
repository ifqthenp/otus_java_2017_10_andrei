package com.otus;


import com.otus.dbService.DBService;
import com.otus.dbService.DBServiceImpl;
import com.otus.entities.AddressDataSet;
import com.otus.entities.PhoneDataSet;
import com.otus.entities.UserDataSet;

import java.util.ArrayList;
import java.util.List;

public class Application
{
    public static void main(String[] args)
    {
        try {
            DBService dbService = new DBServiceImpl();
            String status = dbService.getLocalStatus();
            System.out.println("Status: " + status);

            UserDataSet carl = getCarl();
            UserDataSet harry = getHarry();

            dbService.save(carl);
            dbService.save(harry);

            carl = dbService.read(1);
            System.out.println("Read by ID: " + carl);

            harry = dbService.read(2);
            System.out.println("Read by ID: " + harry);

            carl = dbService.readByName("carl");
            System.out.println("Read by name: " + carl);

            harry = dbService.readByName("harry");
            System.out.println("Read by name: " + harry);

            System.out.println("Read all from list: ");
            List<UserDataSet> dataSets = dbService.readAll();
            for (UserDataSet userDataSet : dataSets) {
                System.out.println(userDataSet);
            }

            dbService.shutdown();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static UserDataSet getCarl()
    {
        UserDataSet carl = new UserDataSet();
        carl.setName("carl");
        carl.setAddressDataSet(new AddressDataSet("Peshkov Street"));
        List<PhoneDataSet> tullyPhoneNumbers = new ArrayList<>();
        tullyPhoneNumbers.add(new PhoneDataSet("01632 960230"));
        tullyPhoneNumbers.add(new PhoneDataSet("01632 960665"));
        tullyPhoneNumbers.add(new PhoneDataSet("01632 960425"));
        carl.setPhoneNumbers(tullyPhoneNumbers);
        return carl;
    }

    private static UserDataSet getHarry()
    {
        UserDataSet harry = new UserDataSet();
        harry.setName("harry");
        harry.setAddressDataSet(new AddressDataSet("Oxford Street"));
        List<PhoneDataSet> sullyPhoneNumbers = new ArrayList<>();
        sullyPhoneNumbers.add(new PhoneDataSet("01632 960979"));
        sullyPhoneNumbers.add(new PhoneDataSet("01632 960220"));
        harry.setPhoneNumbers(sullyPhoneNumbers);
        return harry;
    }
}
