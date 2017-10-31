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

    /**
     * Returns true if this list contains the specified element.
     * More formally, returns true if and only if this list contains
     * at least one element e such that (o==null ? e==null : o.equals(e)).
     *
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    public boolean contains(final Object o)
    {
        if (o == null) {
            for (int i = 0; i < this.size(); i++) {
                if (data[i] == null) return true;
            }
        } else {
            for (int i = 0; i < this.size(); i++) {
                if (o.equals(data[i])) return true;
            }
        }
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

    /**
     * Removes the first occurrence of the specified element from
     * this list, if it is present.
     *
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    public boolean remove(final Object o)
    {
        for (int i = 0; i < this.size(); i++) {
            if (data[i].equals(o)) {
                if (i != this.size() - 1) {
                    System.arraycopy(data, i + 1, data, i, this.size() - i - 1);
                }
                size--;
                return true;
            }
        }
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

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    public void clear()
    {
        this.data = (E[]) new Object[1];
        this.size = 0;
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

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element. More formally,
     * returns the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))),
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     */
    public int indexOf(final Object o)
    {
        if (o == null) {
            for (int i = 0; i < this.size(); i++) {
                if (data[i] == null) return i;
            }
        } else {
            for (int i = 0; i < this.size(); i++) {
                if (o.equals(data[i])) return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified
     * element in this list, or -1 if this list does not contain
     * the element.* More formally, returns the highest index i
     * such that (o==null ? get(i)==null : o.equals(get(i))), or
     * -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element
     */
    public int lastIndexOf(final Object o)
    {
        int lastIndex = -1;
        if (o == null) {
            for (int i = 0; i < this.size(); i++) {
                if (data[i] == null) {
                    lastIndex = getLastIndexOf(i, lastIndex);
                }
            }
        } else {
            for (int i = 0; i < this.size(); i++) {
                if (o.equals(data[i])) {
                    lastIndex = getLastIndexOf(i, lastIndex);
                }
            }
        }
        return lastIndex;
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
     * Helper method to find last index of specified element in this list.
     *
     * @param currIndex current index of the element
     * @param lastIndex last index of the element
     * @return last index of the element in this list
     */
    private int getLastIndexOf(final int currIndex, final int lastIndex)
    {
        return currIndex > lastIndex ? currIndex : lastIndex;
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

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < this.size(); i++) {
            if (i < this.size() - 1) {
                result.append(data[i]).append(", ");
            } else {
                result.append(data[i]);
            }
        }
        return result.append("]").toString();
    }
}
