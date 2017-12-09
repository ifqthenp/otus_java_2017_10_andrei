package ru.otus.classes;


import java.util.SortedMap;
import java.util.TreeMap;

import static java.util.Comparator.comparing;

/**
 * {@code CashBuilder} class defines all available banknotes denominations in
 * cash machine and default amount for each denomination.
 */
public class AtmBuilder
{
    private SortedMap<Integer, Integer> cashMap;

    public AtmBuilder()
    {
        this.cashMap = new TreeMap<>(comparing(Integer::intValue).reversed());
    }

    public AtmBuilder banknote(final int denomination, final int amount)
    {
        this.cashMap.put(denomination, amount);
        return this;
    }

    public SortedMap<Integer, Integer> getCashMap()
    {
        return this.cashMap;
    }

    public AtmImp build()
    {
        return AtmImp.loadCash(this);
    }
}
