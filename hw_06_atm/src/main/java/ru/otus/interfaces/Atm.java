package ru.otus.interfaces;

/**
 * {@code Atm} describes operations allowed for an Automated
 * Teller Machine (ATM) that implements this interface.
 */
public interface Atm
{
    /**
     * Allows user to withdraw given amount of cash from an cash machine.
     *
     * @param amount amount of cash to withdraw
     */
    void withdraw(int amount);

    /**
     * Gets total amount of cash available in cash machine.
     *
     * @return total amount of cash
     */
    int getCashTotal();
}
