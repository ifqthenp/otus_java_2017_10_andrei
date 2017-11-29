package ru.otus.classes;

import ru.otus.interfaces.AtmOperations;

import java.util.Map;

/**
 * {@code ATM} class.
 */
public class ATM implements AtmOperations
{
    private static final long ID = 1001L;
    private ATM.Cash atmCash;

    private ATM(final CashBuilder cashBuilder)
    {
        this.atmCash = new ATM.Cash(cashBuilder);
    }

    static ATM loadCash(CashBuilder cashBuilder)
    {
        return new ATM(cashBuilder);
    }

    public Map<Integer, Integer> getCash()
    {
        return this.atmCash.getCash();
    }

    @Override
    public void withdraw(final int amount)
    {

    }

    @Override
    public int getCashTotal()
    {
        return atmCash.getTotal();
    }

    private static class Cash
    {
        private Map<Integer, Integer> cash;

        Cash(final CashBuilder cashBuilder)
        {
            this.cash = cashBuilder.getCashMap();
        }

        Map<Integer, Integer> getCash()
        {
            return this.cash;
        }

        int getTotal()
        {
            return this.cash.entrySet().stream()
                .mapToInt(entry -> entry.getKey() * entry.getValue())
                .sum();
        }
    }
}
