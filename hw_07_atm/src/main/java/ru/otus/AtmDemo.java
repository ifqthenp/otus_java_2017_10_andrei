package ru.otus;

import ru.otus.classes.AtmImp;
import ru.otus.classes.DepartmentImp;
import ru.otus.interfaces.Atm;
import ru.otus.interfaces.Department;

/**
 * {@code ATMTest} class.
 */
public class AtmDemo
{
    public static void main(String[] args)
    {
        Atm atm1 = AtmImp.loadCash();
        Atm atm2 = AtmImp.loadCash();
        Atm atm3 = AtmImp.loadCash();

        Department department = new DepartmentImp();
        department.addAtm(atm1);
        department.addAtm(atm2);
        department.addAtm(atm3);

        System.out.printf("%-25s%d%n", "Before withdrawal:", department.getCashTotal());

        department.saveAllAtmState();

        atm3.withdraw(300);
        atm2.withdraw(100);
        atm1.withdraw(300);

        System.out.printf("%-25s%d%n", "After withdrawal:", department.getCashTotal());

        department.restoreAllAtmState();
        department.restoreAllAtmState();
        department.restoreAllAtmState();

        System.out.printf("%-25s%d%n", "After restoring state:", department.getCashTotal());
    }
}
