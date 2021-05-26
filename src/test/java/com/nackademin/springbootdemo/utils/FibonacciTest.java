package com.nackademin.springbootdemo.utils;


import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ashkan Amiri
 * Date:  2021-05-14
 * Time:  09:30
 * Project: springBootDemo
 * Copyright: MIT
 */
class FibonacciTest {
    Fibonacci f;

    @BeforeAll
    public static void init(){
        System.out.println("Before test class");
    }

    @BeforeEach
    public  void beforeMethode(){
        f = new Fibonacci();
        System.out.println("Before each method");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("after all");
    }

    @AfterEach
    public  void afterEach(){
        System.out.println("after each method");
    }

    @Test
    @DisplayName("Testing fib method will be correct")
    void fib() {
        int expected = 2;
        int actual = f.fib(3);
        assertEquals(expected,actual,"Should be same");
    }

    @Test
    @Disabled
    void fib_throws() {
        f.fib(3);
        List<Integer> testCases =  Arrays.asList(-1,-10,-30);
        for (int n : testCases) {
            assertThrows(IndexOutOfBoundsException.class,()->f.fib(n));
        }

    }
}