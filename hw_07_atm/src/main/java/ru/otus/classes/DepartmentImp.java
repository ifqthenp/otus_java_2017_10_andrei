package ru.otus.classes;

import ru.otus.interfaces.Atm;
import ru.otus.interfaces.Department;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * {@code DepartmentImp} class is an implementation of Department interface.
 */
public class DepartmentImp implements Department
{
    private List<Atm> atmList;
    private Queue<AtmMemento> mementoStack;

    public DepartmentImp()
    {
        this.atmList = new ArrayList<>();
        this.mementoStack = Collections.asLifoQueue(new ArrayDeque<>());
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
    public void restoreAllAtmState()
    {
        for (final Atm atm : atmList) {
            if (mementoStack.peek() != null) {
                atm.revert(mementoStack.remove());
            }
        }
    }

    @Override
    public void saveAllAtmState()
    {
        for (final Atm atm : atmList) {
            mementoStack.add(atm.save());
        }
    }
}
