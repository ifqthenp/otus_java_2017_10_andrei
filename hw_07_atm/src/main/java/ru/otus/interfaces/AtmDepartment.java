package ru.otus.interfaces;

import ru.otus.classes.AtmCaretaker;

import java.math.BigInteger;
import java.util.List;

/**
 * {@code AtmDepartment} interface describes operations allowed
 * to perform for an ATM department.
 */
public interface AtmDepartment
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
     * Adds a list of ATMs to the department.
     *
     * @param atms a list of ATMs to be added to the department
     */
    void addAllAtms(List<Atm> atms);
}
