package ru.otus.interfaces;

import java.util.SortedMap;

/**
 * {@code Atm} describes operations allowed for an Automated
 * Teller Machine (ATM) that implements this interface.
 */
public interface Atm
{
    /**
<<<<<<< HEAD
     * Allows user to withdraw given amount of cash from an cash machine.
=======
     * Allows user to withdraw given amount of cash from a cash machine.
     * The exact amount of cash available for withdrawal is subject to
     * cash machine implementation.
>>>>>>> hw-6-atm
     *
     * @param amount amount of cash to withdraw
     */
    SortedMap<Integer, Integer> withdraw(int amount);

    /**
     * Gets total amount of cash available in cash machine.
     *
     * @return total amount of cash
     */
    int getCashTotal();
}
