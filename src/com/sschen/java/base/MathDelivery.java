package com.sschen.java.base;

import java.util.Scanner;

/**
 * 取模：也就是求余数
 *
 * Math函数提供了封装好的方法来进行计算，实现更方便。
 */
public class MathDelivery {
    private static final int DELIVERY=360;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请输入需要取模的整数（取模范围为0-359）：");
            int inputValue = scanner.nextInt();
            int multiValue = inputValue/DELIVERY;

            System.out.printf("倍数为：%d",multiValue);
            System.out.println();
            System.out.printf("取模：%d",inputValue % DELIVERY);
            System.out.println();
            System.out.printf("倍数值为：%d",multiValue * DELIVERY);
            System.out.println();

            System.out.printf("Math.floorMod：%d",Math.floorMod(inputValue,DELIVERY));
            System.out.println();

        }
    }
}
