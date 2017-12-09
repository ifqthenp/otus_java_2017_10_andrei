package ru.otus.classes;

import ru.otus.interfaces.Atm;
import ru.otus.interfaces.Department;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * {@code CashMachineDepartment} class.
 */
public class DepartmentImp implements Department
{
    private List<Atm> atmList;

    public DepartmentImp()
    {
        this.atmList = new ArrayList<>();
    }

    @Override
    public void addAtm(final Atm atm)
    {
        this.atmList.add(atm);
    }

    @Override
    public BigInteger getDepartmentCashTotal()
    {
        BigInteger sum = BigInteger.ZERO;
        for (final Atm atm : this.atmList) {
            sum = sum.add(BigInteger.valueOf(atm.getCashTotal()));
        }
        return sum;
    }

    @Override
    public void restoreAllAtmState(final AtmCaretaker atmCaretaker)
    {
        for (Atm atm : atmList) {
            atmCaretaker.revert(atm);
        }
    }

    @Override
    public void saveAllAtmState(final AtmCaretaker caretaker)
    {
        for (Atm atm : atmList) {
            caretaker.save(atm);
        }
    }
}
