package ru.otus.classes;

import ru.otus.interfaces.Atm;
import ru.otus.interfaces.AtmDepartment;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * {@code CashMachineDepartment} class.
 */
public class Department implements AtmDepartment
{
    private List<Atm> atms;

    public Department()
    {
        this.atms = new ArrayList<>();
    }

    @Override
    public void addAllAtms(final List<Atm> atms)
    {
        this.atms.addAll(atms);
    }

    @Override
    public BigInteger getDepartmentCashTotal()
    {
        BigInteger sum = BigInteger.ZERO;
        for (Atm atm : this.atms) {
            sum = sum.add(BigInteger.valueOf(atm.getCashTotal()));
        }
        return sum;
    }

    @Override
    public void restoreAllAtmState(final AtmCaretaker atmCaretaker)
    {
        for (Atm atm : atms) {
            atmCaretaker.revert(atm);
        }
    }

    @Override
    public void saveAllAtmState(final AtmCaretaker caretaker)
    {
        for (Atm atm : atms) {
            caretaker.save(atm);
        }
    }
}
