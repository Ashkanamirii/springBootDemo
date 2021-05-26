package com.nackademin.springbootdemo.utils;

/**
 * Created by Ashkan Amiri
 * Date:  2021-05-14
 * Time:  09:27
 * Project: springBootDemo
 * Copyright: MIT
 */
public class Fibonacci {

    public int fib (int n){
        if(n<0){
            throw new IndexOutOfBoundsException("Could not fet fib of : " + n);
        }
        if (n== 1 || n == 0){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
}
