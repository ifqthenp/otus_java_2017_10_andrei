package com.otus.dataset;

/**
 * {@code DataSet} class.
 */
public abstract class DataSet
{
    protected static long id = 0;

    public DataSet()
    {
        id = id + 1;
    }
}
