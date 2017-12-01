package ru.otus.interfaces;

/**
 * {@code AtmMachine} describes operations allowed for an ATM.
 */
public interface AtmMachine
{
    /**
     * Allows user to withdraw given amount of cash from an ATM. The exact
     * amount of cash available for withdrawal is subject to ATM implementation.
     *
     * @param amount amount of cash to withdraw
     */
    void withdraw(int amount);

    /**
     * Gets total amount of cash available in ATM.
     *
     * @return total amount of cash
     */
    int getCashTotal();
}
