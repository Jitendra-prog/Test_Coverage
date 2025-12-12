package com.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator c = new Calculator();
        Assert.assertEquals(c.add(2, 3), 5);
    }

    @Test
    public void testSubtract() {
        Calculator c = new Calculator();
        Assert.assertEquals(c.subtract(10, 4), 6);
    }

    @Test
    public void testMultiply() {
        Calculator c = new Calculator();
        Assert.assertEquals(c.subtract(10, 4), 6);
    }

    @Test
    public void testDivide() {
        Calculator c = new Calculator();
        Assert.assertEquals(c.subtract(10, 4), 6);
    }
}
