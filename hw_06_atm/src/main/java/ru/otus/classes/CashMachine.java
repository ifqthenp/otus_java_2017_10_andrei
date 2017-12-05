package ru.otus.classes;

import ru.otus.interfaces.Atm;

import java.util.SortedMap;
import java.util.TreeMap;

import static java.util.Comparator.comparing;

/**
 * {@code CashMachine} class is an implementation of {@code Atm} interface.
 */
public class CashMachine implements Atm
{
    private static final Denominations[] BANKNOTES = Denominations.values();

    private static final int WITHDRAWAL_LIMIT = 300;

    private SortedMap<Integer, Integer> cash;

    /**
     * Constructs a cash machine with amount of cash defined in {@code cashBuilder}.
     *
     * @param cashBuilder the initial amount of cash available in this ATM
     */
    private CashMachine(final CashBuilder cashBuilder)
    {
        this.cash = cashBuilder.getCashMap();
    }

    /**
     * Static factory to build a cash machine.
     *
     * @return new CashMachine
     */
    public static CashMachine loadCash(final CashBuilder cashBuilder)
    {
        return new CashMachine(cashBuilder);
    }

    @Override
    public int getCashTotal()
    {
        return this.cash.entrySet().stream()
            .mapToInt(entry -> entry.getKey() * entry.getValue())
            .sum();
    }


        SortedMap<Integer, Integer> result =
            new TreeMap<>(comparing(Integer::intValue).reversed());

        cashOperationHelper(result, amount, 0);

        for (Integer key : result.keySet()) {
            if (atm.cash.keySet().contains(key)) {
                atm.cash.put(key, atm.cash.get(key) - result.get(key));
            }
        }
    }

    /**
     * Helper method that factors an amount requested by user into the
     * smallest number of banknotes and puts the result into a map of
     * available denominations in this CashMachine. For example, if user
     * requested 95, the resulting map will be [50=1, 20=2, 5=1] or, if amount
     * requested is 285, the result will be [100=2, 50=1, 20=1, 10=1, 5=1].
     *
     * @param result the map to accumulate results of factoring
     * @param amount the amount requested by user
     * @param index  the index that points to current banknote denomination
     *               in the array of available banknotes for this CashMachine
     */
    private void cashOperationHelper(SortedMap<Integer, Integer> result, int amount, int index)
    {
        if (index == BANKNOTES[BANKNOTES.length - 1]) return;

        if (amount < BANKNOTES[index]) {
            cashOperationHelper(result, amount, index + 1);
        } else {
            result.put(BANKNOTES[index], amount / BANKNOTES[index]);
            amount = amount % BANKNOTES[index];
            cashOperationHelper(result, amount, index + 1);
        }
    }

    @Override
    public int getCashTotal()
    {
        return this.atm.cash.entrySet().stream()
            .mapToInt(entry -> entry.getKey() * entry.getValue())
            .sum();
    }

    /**
     * {@code Cash} class that holds a map of available cash denominations
     * in CashMachine as a key and amount for each denomination as a value.
     */
    private static class Cash
    {
        private SortedMap<Integer, Integer> cash;

        Cash(final CashMachine.CashBuilder cashBuilder)
        {
            this.cash = cashBuilder.getCashMap();
        }
    }

    /**
     * {@code CashBuilder} class defines all available banknotes denominations
     * in CashMachine and default amount for each denomination.
     */
    private static class CashBuilder
    {
        private final static int HUNDRED = 100;
        private final static int FIFTY = 50;
        private final static int TWENTY = 20;
        private final static int TEN = 10;
        private final static int FIVE = 5;

        private final static int DEFAULT_QUANTITY = 10;

        private SortedMap<Integer, Integer> cashMap;

        CashBuilder()
        {
            this.cashMap = new TreeMap<>(comparing(Integer::intValue).reversed());
        }

        CashBuilder hundred()
        {
            this.cashMap.put(HUNDRED, DEFAULT_QUANTITY);
            return this;
        }

        CashBuilder fifty()
        {
            this.cashMap.put(FIFTY, DEFAULT_QUANTITY);
            return this;
        }

        CashBuilder twenty()
        {
            this.cashMap.put(TWENTY, DEFAULT_QUANTITY);
            return this;
        }

        CashBuilder ten()
        {
            this.cashMap.put(TEN, DEFAULT_QUANTITY);
            return this;
        }

        CashBuilder five()
        {
            this.cashMap.put(FIVE, DEFAULT_QUANTITY);
            return this;
        }

        SortedMap<Integer, Integer> getCashMap()
        {
            return this.cashMap;
        }

        CashMachine build()
        {
            return new CashMachine(this);
        }
    }
}
