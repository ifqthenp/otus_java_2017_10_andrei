package ru.otus.hw02;

import java.lang.management.ManagementFactory;

/**
 * VM options -Xmx512m -Xms512m
 */
@SuppressWarnings({"RedundantStringConstructorCall", "InfiniteLoopStatement"})
public class StandDemo
{
    public static void main(String... args) throws InterruptedException, InstantiationException, IllegalAccessException
    {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        int size = 20_000_000;

//        Object object = new Object();
//        Object object = new String("");
//        Object object = new String(new char[0]);
        Object object = new MyClass();

        Stand stand = new Stand();
        stand.getObjectSize(object, size);
    }

    public static class MyClass
    {
        private int i = 0;
        private long l = 1L;
    }
}
