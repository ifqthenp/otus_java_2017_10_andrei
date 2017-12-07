package ru.otus.classes;

import java.util.SortedMap;

/**
 * {@code CashMachineMemento} class.
 */
public class AtmMemento
{
    private SortedMap<Integer, Integer> cash;

    public AtmMemento(final SortedMap<Integer, Integer> cash)
    {
        this.cash = cash;
    }

    public SortedMap<Integer, Integer> getSavedState()
    {
        return this.cash;
    }
}
