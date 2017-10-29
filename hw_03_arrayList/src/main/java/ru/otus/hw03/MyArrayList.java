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
        if (capacity < 0) {
            throw new IllegalArgumentException("Array size cannot be negative: " + capacity);
        }
        data = (E[]) new Object[capacity];
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size()
    {
        return this.size;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty()
    {
        return this.size == 0;
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

    /**
     * Appends the specified element to the end of this list.
     *
     * @param newElement element to be appended to this list
     * @return true (as specified by {@code Collection.add(E)})
     */
    public boolean add(final E newElement)
    {
        growArrayIfNecessary();
        this.size++;
        data[size - 1] = newElement;
        return true;
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

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return element at the specified position in this list
     */
    public E get(final int index)
    {
        checkIndex(index);
        return this.data[index];
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

    /**
     * Helper method to grow the size of this array when it is full.
     * The array will grow twice the size of the original array.
     */
    private void growArrayIfNecessary()
    {
        if (this.size == this.data.length) {
            final int growFactor = 2;
            final int newCapacity = this.data.length * growFactor;
            E[] temp = (E[]) new Object[newCapacity];
            System.arraycopy(this.data, 0, temp, 0, this.size);
            this.data = temp;
        }
    }

    /**
     * Helper method to check if index supplied is valid.
     */
    private void checkIndex(final int index)
    {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index is not valid: " + index);
        }
    }
}
