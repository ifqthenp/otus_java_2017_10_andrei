package ru.otus.tests;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

/**
 * {@code FrameworkFirstTest} class with test classes.
 */
public class FrameworkFirstTest
{
    private String testString;

    @Before
    public void setUp()
    {
        this.testString = "Hello, ";
        System.out.println("@Before: " + this.testString);
    }

    @Test
    public void firstTestMethod()
    {
        this.testString += "Harry Hacker!";
        System.out.println("FrameworkFirstTest.firstTestMethod");
        System.out.println("@Test: " + this.testString);
    }

    @Test
    public void secondTestMethod()
    {
        this.testString += "Carl Cracker!";
        System.out.println("FrameworkFirstTest.secondTestMethod");
        System.out.println("@Test: " + this.testString);
    }

    @Test
    public void thirdTestMethod()
    {
        this.testString += "Tony Tester!";
        System.out.println("FrameworkFirstTest.thirdTestMethod");
        System.out.println("@Test: " + this.testString);
    }

    public void fourthTestMethod()
    {
        System.err.println("FrameworkFirstTest.fourthTestMethod");
        System.err.println("Fail. Should not be invoked.");
    }

    @After
    public void tearDown()
    {
        this.testString = null;
        System.out.println("@After: " + null + "\n");
    }
}
