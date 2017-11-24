package ru.otus.tests;

import ru.otus.annotations.Test;

import java.math.BigInteger;

/**
 * {@code FrameworkSecondTest} class with test classes.
 */
public class FrameworkSecondTest
{
    @Test
    public void firstTestMethodInSecondClass()
    {
        final BigInteger prize = new BigInteger("1000000");
        System.out.println("FrameworkSecondTest.firstTestMethodInSecondClass");
        System.out.println("Congratulations! You have won $" + prize.toString() + "\n");
    }
}
