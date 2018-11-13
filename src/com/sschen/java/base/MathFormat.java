package com.sschen.java.base;

import java.util.Scanner;

/**
 * 数字格式化
 *
 * 使用不同的格式化方式，将整数转换为二进制、八进制、十六进制、反数的十六进制浮点数
 */
public class MathFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入需要转换进制的整数：");
            int inputValue = scanner.nextInt();

            System.out.println("二进制: " + Integer.toBinaryString(inputValue));
            System.out.printf("八进制：%o",inputValue);
            System.out.println();
            System.out.printf("十六进制：%X",inputValue);
            System.out.println();
            System.out.printf("十六进制指数：%Xf",-inputValue);
            System.out.println();
        }
    }
}
