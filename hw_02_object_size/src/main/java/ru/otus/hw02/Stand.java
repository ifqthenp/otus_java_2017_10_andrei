package ru.otus.hw02;

/**
 * {@code Stand} class to calculate size of java object.
 */
public class Stand
{
    public void getObjectSize(final Object o, final int size) throws InterruptedException, IllegalAccessException, InstantiationException
    {
        System.out.printf("Starting the loop...%n");
        while (true) {

            System.gc();

            long memBefore = getMemoryDifference();
            System.out.printf("%-35s%d%n", "Memory used", memBefore);

            Object[] array = new Object[size];
            System.out.printf("%-35s%d%n", "Created new array of size", array.length);

            for (int i = 0; i < size; i++) {
                array[i] = o.getClass().newInstance();
            }

            System.out.printf("%-35s%d%n", "Number of objects created", size);

            long memAfter = getMemoryDifference();
            System.out.printf("%-35s%d%n", "Memory used", memAfter);

            System.out.printf("%-35s%d%n%n", o.getClass().getName(), (memAfter - memBefore) / size);

            cleanMemory();
        }
    }

    private void cleanMemory() throws InterruptedException
    {
        System.gc();
        Thread.sleep(1000);
    }

    private long getMemoryDifference()
    {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
