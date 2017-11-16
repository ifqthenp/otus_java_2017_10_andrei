package ru.otus.gc;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * {@code GCDemo} class.
 */
public class GCDemo
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Starting pid: " + ManagementFactory.getRuntimeMXBean().getName());

//        int size = 5 * 1000 * 1000;
//        int size = 50 * 1000 * 1000;//for OOM with -Xms512m
        int size = 5 * 1000 * 1000; //for small dump

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("ru.otus:type=Benchmark");
        Benchmark mbean = new Benchmark();
        mbs.registerMBean(mbean, name);

        mbean.setSize(size);
        mbean.run();
    }
}
