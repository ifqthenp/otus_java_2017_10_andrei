package ru.otus.hw02;

import java.util.function.Supplier;

/**
 * {@code Stand} class to calculate size of java object.
 */
public class Stand
{
    /**
     * Measures the size of Java object.
     *
     * @param supplier supplier that generates values for array of objects
     * @param size     size of the objects array
     */
    public <T> Object getObjectSize(final Supplier<T> supplier, final int size)
    {
        final Object[] objects = new Object[size];
        Runtime runtime = Runtime.getRuntime();

        runtime.gc();

        long memBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int i = 0; i < size; i++) {
            objects[i] = supplier.get();
        }

        runtime.gc();
        long memAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.printf("%-42s%d%n", supplier.get().getClass().getCanonicalName(), Math.round((double) (memAfter - memBefore) / size));

        return objects;
    }
}
