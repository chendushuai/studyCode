package com.sschen.java.base;

import java.math.BigDecimal;

/**
 * Java 入门，打印HelloWorld
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");

        // 下划线自动去除
        int intValue=100_000_000;
        System.out.println(intValue);
        System.out.println("Int MaxValue:" + Integer.MAX_VALUE +", Int MinValue:" + Integer.MIN_VALUE);
        System.out.println("Long MaxValue:" + Long.MAX_VALUE +", Long MinValue:" + Long.MIN_VALUE);
        System.out.println("Float MaxValue:" + Float.MAX_VALUE +", Float MinValue:" + Float.MIN_VALUE);
        System.out.println("Double MaxValue:" + Double.MAX_VALUE +", Double MinValue:" + Double.MIN_VALUE);

        double i=2.0,j=1.1;
        System.out.println("Double MaxValue:" + (i-j) +", BigDecimal MinValue:" + (BigDecimal.valueOf(i).subtract(BigDecimal.valueOf(j))));

    }
}
