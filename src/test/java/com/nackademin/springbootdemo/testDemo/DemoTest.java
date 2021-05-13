package com.nackademin.springbootdemo.testDemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ashkan Amiri
 * Date:  2021-05-13
 * Time:  17:37
 * Project: springBootDemo
 * Copyright: MIT
 */
public class DemoTest {
    List<Integer> list = new ArrayList<>();

    @Before
    public void fillList() {
        list.add(1);
        list.add(10);
        list.add(100);
        list.add(1000);
        System.out.println("before @");
    }

    @After
    public void afterMethod() {
        System.out.println("------after");
    }

    @Test
    public void checkLength() {
        System.out.println("check length");
        assertEquals(list.size(), 4);
    }

    @Test
    public void checkFirstElement() {
        System.out.println("check first element");
        assertEquals(list.get(0), 1);
    }

    @Test
    public void checkSecondElement() {
        System.out.println("check first element");
        assertNotEquals(list.get(1), 1);
    }

    @Test
    public void testAssertSame() {
        Integer aNumber = Integer.valueOf(500);
        assertNotSame(aNumber, 500, "should be same reference when you compare the object");
        //assertSame(aNumber, 500, "should be same reference when you compare the object"); false!!!
    }

}
