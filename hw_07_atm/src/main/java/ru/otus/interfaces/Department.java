package ru.otus.interfaces;

import java.math.BigInteger;

/**
 * {@code AtmDepartment} interface describes operations allowed
 * to perform for an ATM department.
 */
public interface Department
{
    /**
     * Gets the total sum of the cash in all ATMs belonging to this department.
     *
     * @return total cash sum in all department's ATMs
     */
    BigInteger getDepartmentCashTotal();

    /**
     * Sets each ATM in the department to its previously saved state.
     */
    void restoreAllAtmState();

    /**
     * Saves the current state of each ATM in the department.
     */
    void saveAllAtmState();

    /**
     * Adds an ATM to the department.
     *
     * @param atm an ATM to be added to the department
     */
    void addAtm(Atm atm);
}
