package ru.otus.hw02;

import java.util.function.Supplier;

/**
 * {@code Stand} class to calculate size of java object.
 */
public class Stand
{
    public void getObjectSize(final Supplier<Object> o, final int size) throws InterruptedException
    {
        cleanMemory();

        long memBefore = getMemoryDifference();

        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = o.get();
        }

        long result = (getMemoryDifference() - memBefore) / size;
        System.out.printf("%-42s%d%n", array[0].getClass().getCanonicalName(), result);

        cleanMemory();
    }

    private void cleanMemory() throws InterruptedException
    {
        System.gc();
        Thread.sleep(10);
    }

    private long getMemoryDifference()
    {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
