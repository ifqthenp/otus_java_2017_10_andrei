package ru.otus.interfaces;

/**
 * {@code Atm} describes operations allowed for an Automated
 * Teller Machine (ATM) that implements this interface.
 */
public interface Atm
{
    /**
     * Allows user to withdraw given amount of cash from an CashMachine. The exact
     * amount of cash available for withdrawal is subject to CashMachine implementation.
     *
     * @param amount amount of cash to withdraw
     */
    void withdraw(int amount);

    /**
     * Gets total amount of cash available in CashMachine.
     *
     * @return total amount of cash
     */
    int getCashTotal();
}
