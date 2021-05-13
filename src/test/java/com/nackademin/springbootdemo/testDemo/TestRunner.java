package com.nackademin.springbootdemo.testDemo;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Ashkan Amiri
 * Date:  2021-05-13
 * Time:  18:18
 * Project: springBootDemo
 * Copyright: MIT
 */
public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestSuite.class);
        for (Failure f : result.getFailures()) {
            System.out.println(f.getMessage());
            System.out.println(f.getDescription());
        }
        System.out.println(result.getFailureCount());
        System.out.println(result.getRunCount());
        System.out.println(result.wasSuccessful());
    }
}
