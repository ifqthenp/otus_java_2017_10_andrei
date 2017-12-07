package ru.otus.classes;


import java.util.SortedMap;
import java.util.TreeMap;

import static java.util.Comparator.comparing;

/**
 * {@code CashBuilder} class defines all available banknotes denominations in
 * cash machine and default amount for each denomination.
 */
public class CashBuilder
{
    private SortedMap<Integer, Integer> cashMap;

    public CashBuilder()
    {
        this.cashMap = new TreeMap<>(comparing(Integer::intValue).reversed());
    }

    public CashBuilder banknote(final int denomination, final int amount)
    {
        this.cashMap.put(denomination, amount);
        return this;
    }

    public SortedMap<Integer, Integer> getCashMap()
    {
        return this.cashMap;
    }

    public ConcreteAtm build()
    {
        return ConcreteAtm.loadCash(this);
    }
}
