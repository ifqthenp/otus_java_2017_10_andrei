package ru.otus.hw02;

import java.lang.management.ManagementFactory;

/**
 * Homework 2. Size of java object.
 * VM options: -Xmx64m -Xms64m -XX:-UseCompressedOops -XX:+PrintGCDetails
 */
@SuppressWarnings({"RedundantStringConstructorCall", "InfiniteLoopStatement"})
public class StandDemo
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        int size = 100_000;

        Stand stand = new Stand();

        stand.getObjectSize(Object::new, size);
        stand.getObjectSize(() -> new String(""), size);
        stand.getObjectSize(() -> new String(new char[]{}), size);

        stand.getObjectSize(MyClass::new, size);
        stand.getObjectSize(MyClassWithString::new, size);

        stand.getObjectSize(() -> new int[0], size);
        stand.getObjectSize(() -> new int[100], size);
    }

    private static class MyClass
    {
        private int i = 0;
        private long l = 1L;
    }

    private static class MyClassWithString
    {
        private int i = 0;
        private long l = 1L;
        private String s = "";
    }
}
