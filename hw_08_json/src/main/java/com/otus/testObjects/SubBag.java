package com.otus.testObjects;

import java.math.BigInteger;
import java.util.*;

/**
 * {@code SubBag} class.
 */
public class SubBag extends SuperBag
{
    private long longValue;
    private int intValue;
    private boolean booleanValue;
    private String stringValue;

    public SubBag()
    {
        this.longValue = Long.MIN_VALUE;
        this.intValue = Integer.MIN_VALUE;
        this.booleanValue = true;
        this.stringValue = "sub string";
        final BigInteger subBigInteger = new BigInteger("11111");
        final List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
    }
}
