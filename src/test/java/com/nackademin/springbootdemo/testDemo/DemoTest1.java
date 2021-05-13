package com.nackademin.springbootdemo.testDemo;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.allOf;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Ashkan Amiri
 * Date:  2021-05-13
 * Time:  18:07
 * Project: springBootDemo
 * Copyright: MIT
 */
public class DemoTest1 {

    @Test
    public void testAssertNull(){
        assertNull(null,"should be null");
    }


    @Test
    public void testAssertThatHamcrestCoreMatchers(){
        assertTrue(true,"should be true");
    }
}
