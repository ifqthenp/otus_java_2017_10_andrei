package com.otus.testObjects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * {@code GsonTest} class.
 */
public class GsonTest
{
    public static void main(String[] args)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String result = gson.toJson(new SubBag());
        System.out.println(result);

    }
}
