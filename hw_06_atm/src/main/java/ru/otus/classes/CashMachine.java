package ru.otus.classes;

import ru.otus.interfaces.Atm;

import java.util.SortedMap;
import java.util.TreeMap;

import static java.util.Comparator.comparing;

/**
 * {@code AtmImpl} class.
 */
public class AtmImpl implements Atm
{
    private static final int[] BANKNOTES = {
        CashBuilder.HUNDRED,
        CashBuilder.FIFTY,
        CashBuilder.TWENTY,
        CashBuilder.TEN,
        CashBuilder.FIVE
    };

    private static final int WITHDRAWAL_LIMIT = 300;

    private AtmImpl.Cash atm;

    /**
     * Constructs an AtmImpl with amount of cash defined in cashBuilder.
     *
     * @param cashBuilder the cash builder with available denominations and amount
     */
    private AtmImpl(final AtmImpl.CashBuilder cashBuilder)
    {
        this.atm = new Cash(cashBuilder);
    }

    /**
     * Static factory to build an AtmImpl.
     *
     * @return new AtmImpl
     */
    public static AtmImpl loadCash()
    {
        return new AtmImpl.CashBuilder().hundred().fifty().twenty().ten().five().build();
    }

    @Override
    public void withdraw(final int amount)
    {
        final int minDenomination = atm.cash.lastKey();
        if (amount % minDenomination != 0 || amount < minDenomination) {
            throw new IllegalArgumentException(
                "Amount is less or is not multiple of " + minDenomination);
        }

        if (amount > WITHDRAWAL_LIMIT) {
            throw new IllegalArgumentException("Max withdrawal amount is " + WITHDRAWAL_LIMIT);
        }

        if (amount > this.getCashTotal()) {
            throw new IllegalArgumentException("Not enough cash in this AtmImpl");
        }


        SortedMap<Integer, Integer> result =
            new TreeMap<>(comparing(Integer::intValue).reversed());

        cashOperationHelper(result, amount, 0);

        for (Integer key : result.keySet()) {
            if (atm.cash.keySet().contains(key)) {
                atm.cash.put(key, atm.cash.get(key) - result.get(key));
            }
        }

        result.forEach((k, v) -> System.out.printf("%3d : %3d%n", k, v));
        atm.cash.forEach((k, v) -> System.out.printf("%3d : %3d%n", k, v));
    }

    /**
     * Helper method that factors an amount requested by user into the
     * smallest number of banknotes and puts the result into a map of
     * available denominations in this AtmImpl. For example, if user requested
     * 95, the resulting map will be [50=1, 20=2, 5=1] or, if amount requested
     * is 285, the result will be [100=2, 50=1, 20=1, 10=1, 5=1].
     *
     * @param result the map to accumulate results of factoring
     * @param amount the amount requested by user
     * @param index  the index that points to current banknote denomination
     *               in the array of available banknotes for this AtmImpl
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
     * in AtmImpl as a key and amount for each denomination as a value.
     */
    private static class Cash
    {
        private SortedMap<Integer, Integer> cash;

        Cash(final AtmImpl.CashBuilder cashBuilder)
        {
            this.cash = cashBuilder.getCashMap();
        }
    }

    /**
     * {@code CashBuilder} class defines all available cash denominations
     * in AtmImpl and default amount for each denomination.
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

        AtmImpl build()
        {
            return new AtmImpl(this);
        }
    }
}
