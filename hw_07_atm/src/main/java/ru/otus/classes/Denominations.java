package ru.otus.classes;

/**
 * {@code Denominations} class.
 */
public enum Denominations
{
    HUNDRED(100), FIFTY(50), TWENTY(20), TEN(10), FIVE(5);

    private static final int DEFAULT_AMOUNT = 10;

    private Integer denomination;

    Denominations(int value)
    {
        this.denomination = value;
    }

    public Integer getValue()
    {
        return this.denomination;
    }

    public static int getDefaultAmount()
    {
        return DEFAULT_AMOUNT;
    }
}
