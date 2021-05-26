package com.nackademin.springbootdemo.utils;

import com.nackademin.springbootdemo.utils.Calculator;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Created by Ashkan Amiri
 * Date:  2021-05-13
 * Time:  21:26
 * Project: springBootDemo
 * Copyright: MIT
 */
public class CalculatorTest {

    @Test
    public void testAdd(){
        Calculator c = new Calculator();
        assertEquals(c.add(2,2),4,"should be same");
        assertNotEquals(c.add(2,3),4,"should be same");
    }
}
