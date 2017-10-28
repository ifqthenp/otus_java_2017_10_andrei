package ru.otus.hw03;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * {@code MyArrayList} class. Array-based implementation of array list.
 */
@SuppressWarnings("unchecked")
public class MyArrayList<E> implements List<E>
{
    public static final int CAPACITY = 16;
    private E[] data;
    private int size;

    /**
     * Constructs list with default capacity.
     */
    public MyArrayList()
    {
        this(CAPACITY);
    }

    /**
     * Constructs list with given capacity.
     *
     * @param capacity the given capacity of this list
     */
    public MyArrayList(final int capacity)
    {
        data = (E[]) new Object[capacity];
    }

    public int size()
    {
        return 0;
    }

    public boolean isEmpty()
    {
        return false;
    }

    public boolean contains(final Object o)
    {
        return false;
    }

    public Iterator<E> iterator()
    {
        return null;
    }

    public Object[] toArray()
    {
        return new Object[0];
    }

    public <T> T[] toArray(final T[] a)
    {
        return null;
    }

    public boolean add(final E e)
    {
        return false;
    }

    public boolean remove(final Object o)
    {
        return false;
    }

    public boolean containsAll(final Collection<?> c)
    {
        return false;
    }

    public boolean addAll(final Collection<? extends E> c)
    {
        return false;
    }

    public boolean addAll(final int index, final Collection<? extends E> c)
    {
        return false;
    }

    public boolean removeAll(final Collection<?> c)
    {
        return false;
    }

    public boolean retainAll(final Collection<?> c)
    {
        return false;
    }

    public void clear()
    {

    }

    public E get(final int index)
    {
        return null;
    }

    public E set(final int index, final E element)
    {
        return null;
    }

    public void add(final int index, final E element)
    {

    }

    public E remove(final int index)
    {
        return null;
    }

    public int indexOf(final Object o)
    {
        return 0;
    }

    public int lastIndexOf(final Object o)
    {
        return 0;
    }

    public ListIterator<E> listIterator()
    {
        return null;
    }

    public ListIterator<E> listIterator(final int index)
    {
        return null;
    }

    public List<E> subList(final int fromIndex, final int toIndex)
    {
        return null;
    }
}
