package ru.otus.interfaces;

import ru.otus.classes.AtmCaretaker;

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
     * Sets all ATMs in the department to the previously saved state.
     *
     * @param caretaker a data structure to retrieve the state of an ATM
     */
    void restoreAllAtmState(AtmCaretaker caretaker);

    /**
     * Save the current state of all ATMs in the department.
     *
     * @param caretaker a data structure to save the state of an ATM
     */
    void saveAllAtmState(AtmCaretaker caretaker);

    /**
     * Adds an ATM to the department.
     *
     * @param atm an ATM to be added to the department
     */
    void addAtm(Atm atm);
}
