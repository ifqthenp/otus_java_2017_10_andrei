package com.otus.testObjects;

import java.math.BigDecimal;
import java.util.*;

/**
 * {@code SuperBag} class.
 */
public class SuperBag
{
    private int superIntValue;
    private int[] ints;
    private String superString;
    private BigDecimal bigDecimal;
    private Collection<Integer> superIntegers;

    public SuperBag()
    {
        this.superString = "super string";
        this.superIntValue = Integer.MAX_VALUE;
        this.superIntegers = new ArrayList<>();
        this.superIntegers.add(1);
        this.superIntegers.add(2);
        this.superIntegers.add(3);
        this.ints = new int[3];
        this.ints[0] = 0;
        this.ints[1] = 1;
        this.ints[2] = 2;
        this.bigDecimal = new BigDecimal("100000000");
    }
}
