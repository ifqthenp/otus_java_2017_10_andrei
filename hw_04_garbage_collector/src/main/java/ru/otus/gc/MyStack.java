package ru.otus.gc;

import javax.naming.OperationNotSupportedException;
import java.util.EmptyStackException;

/**
 * {@code MyStack} class.
 */
@SuppressWarnings("unchecked")
public class MyStack<E>
{
    private final static int INITIAL_CAPACITY = 1_000_000;
    private E[] elements;
    private int size;

    public MyStack()
    {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void push(E element)
    {
        ensureCapacity();
        elements[size++] = element;
    }

    private void ensureCapacity()
    {
        if (this.size == this.elements.length) {
            final int growFactor = 2;
            final int newCapacity = this.elements.length * growFactor;
            E[] temp = (E[]) new Object[newCapacity];
            System.arraycopy(this.elements, 0, temp, 0, this.size);
            this.elements = temp;
        }
    }

    public Object pop()
    {
        if (this.size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    public Object peek() throws OperationNotSupportedException
    {
        throw new OperationNotSupportedException("peek");
    }

    public boolean empty()
    {
        return this.size == 0;
    }
}
