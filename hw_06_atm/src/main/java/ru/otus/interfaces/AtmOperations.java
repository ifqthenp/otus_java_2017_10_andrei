package ru.otus.interfaces;

/**
 * {@code AtmOperations} describes operations allowed
 * for ATM that implements this interface.
 */
public interface AtmOperations
{
    void withdraw(int amount);

    int getCashTotal();
}
