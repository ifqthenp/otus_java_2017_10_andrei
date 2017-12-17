package com.otus.interfaces;

/**
 * {@code MyJsonWriter} class.
 */
public interface ObjectProcessor
{
    String process(Object o) throws NoSuchFieldException, IllegalAccessException;
}
