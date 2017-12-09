package ru.otus;

import ru.otus.classes.AtmBuilder;
import ru.otus.interfaces.Atm;

import static ru.otus.classes.Denominations.*;

/**
 * {@code ATMTest} class.
 */
public class AtmDemo
{
    private final static int DEFAULT_AMOUNT = 10;

    public static void main(String[] args)
    {
        Atm atm1 = new AtmBuilder()
            .banknote(HUNDRED.getValue(), DEFAULT_AMOUNT)
            .banknote(FIFTY.getValue(), DEFAULT_AMOUNT)
            .banknote(TWENTY.getValue(), DEFAULT_AMOUNT)
            .banknote(TEN.getValue(), DEFAULT_AMOUNT)
            .banknote(FIVE.getValue(), DEFAULT_AMOUNT)
            .build();

        Atm atm2 = new AtmBuilder()
            .banknote(HUNDRED.getValue(), DEFAULT_AMOUNT)
            .banknote(FIFTY.getValue(), DEFAULT_AMOUNT)
            .banknote(TWENTY.getValue(), DEFAULT_AMOUNT)
            .banknote(TEN.getValue(), DEFAULT_AMOUNT)
            .banknote(FIVE.getValue(), DEFAULT_AMOUNT)
            .build();

        Atm atm3 = new AtmBuilder()
            .banknote(HUNDRED.getValue(), DEFAULT_AMOUNT)
            .banknote(FIFTY.getValue(), DEFAULT_AMOUNT)
            .banknote(TWENTY.getValue(), DEFAULT_AMOUNT)
            .banknote(TEN.getValue(), DEFAULT_AMOUNT)
            .banknote(FIVE.getValue(), DEFAULT_AMOUNT)
            .build();

    }
}
