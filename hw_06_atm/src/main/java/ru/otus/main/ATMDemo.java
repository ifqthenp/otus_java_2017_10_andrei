package ru.otus.main;

import ru.otus.classes.CashBuilder;
import ru.otus.interfaces.Atm;

import java.util.Map;

/**
 * {@code ATMDemo} class.
 */
public class ATMDemo
{
    public static void main(String[] args)
    {
        Atm atm = new CashBuilder().hundred().fifty().twenty().ten().five().build();

        System.out.printf("%-27s%d%n", "Total cash loaded in ATM:", atm.getCashTotal());


        int amountToWithdraw = 295;
        System.out.printf("%-27s%d%n", "Amount requested:", amountToWithdraw);

        Map<Integer, Integer> cashWithdrawn = atm.withdraw(amountToWithdraw);

        System.out.printf("%-27s%d%n%n", "Total cash left in ATM:", atm.getCashTotal());

        System.out.println("Cash given out:");
        cashWithdrawn.forEach((k, v) -> System.out.printf("$ %3d : %d%n", k, v));
    }
}
