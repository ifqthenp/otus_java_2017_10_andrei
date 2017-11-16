package ru.otus.gc;

/**
 * {@code Benchmark} class.
 */
public class Benchmark implements BenchmarkMBean
{
    private static MyStack<String> stack = new MyStack<>();
    private volatile int size = 0;

    @SuppressWarnings("InfiniteLoopStatement")
    void run() throws InterruptedException
    {
        String str1 = "Hello";
        String str2 = "stack";

        while (true) {
            stack.push(str1);
            stack.push(str2);
        }
    }

    @Override
    public int getSize()
    {
        return this.size;
    }

    @Override
    public void setSize(final int size)
    {
        this.size = size;
    }
}
