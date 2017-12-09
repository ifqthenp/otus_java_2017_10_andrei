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
    private List<Atm> atms;

    public DepartmentImp()
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
        for (final Atm atm : this.atms) {
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
