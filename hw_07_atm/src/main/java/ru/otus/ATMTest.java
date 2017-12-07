package ru.otus;

import ru.otus.classes.AtmCaretaker;
import ru.otus.classes.CashBuilder;
import ru.otus.classes.Department;
import ru.otus.interfaces.Atm;
import ru.otus.interfaces.AtmDepartment;

import java.util.ArrayList;
import java.util.List;

import static ru.otus.classes.Denominations.*;

/**
 * {@code ATMTest} class.
 */
public class ATMTest
{
    public static void main(String[] args)
    {
        Atm atm1 = new CashBuilder()
            .banknote(HUNDRED.getValue(), 10)
            .banknote(FIFTY.getValue(), 10)
            .banknote(TWENTY.getValue(), 10)
            .banknote(TEN.getValue(), 10)
            .banknote(FIVE.getValue(), 10)
            .build();

        Atm atm2 = new CashBuilder()
            .banknote(HUNDRED.getValue(), 10)
            .banknote(FIFTY.getValue(), 10)
            .banknote(TWENTY.getValue(), 10)
            .banknote(TEN.getValue(), 10)
            .banknote(FIVE.getValue(), 10)
            .build();

        Atm atm3 = new CashBuilder()
            .banknote(HUNDRED.getValue(), 10)
            .banknote(FIFTY.getValue(), 10)
            .banknote(TWENTY.getValue(), 10)
            .banknote(TEN.getValue(), 10)
            .banknote(FIVE.getValue(), 10)
            .build();

        List<Atm> atmList = new ArrayList<>();
        atmList.add(atm1);
        atmList.add(atm2);
        atmList.add(atm3);

        AtmDepartment atmDepartment = new Department();
        atmDepartment.addAllAtms(atmList);

        System.out.printf("%30s %d%n",
                          "Initial amount of cash in the department",
                          atmDepartment.getDepartmentCashTotal());

        AtmCaretaker atmCaretaker = new AtmCaretaker();

        atmDepartment.saveAllAtmState(atmCaretaker);

        atm1.withdraw(300);
        atm2.withdraw(200);
        atm3.withdraw(50);

        System.out.printf("%30s %d%n",
                          "Amount of cash in the department after cash withdrawal",
                          atmDepartment.getDepartmentCashTotal());

        atmDepartment.restoreAllAtmState(atmCaretaker);

        System.out.printf("%30s %d%n",
                          "Amount of cash in the department after revert",
                          atmDepartment.getDepartmentCashTotal());
    }
}
