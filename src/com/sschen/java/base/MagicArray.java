package com.sschen.java.base;

import java.util.ArrayList;
import java.util.Scanner;

public class MagicArray {
    private static int lineItemCount = -1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入二维数组，以空行结束 : ");
        String inputValue = scanner.nextLine();
        inputValue=inputValue.trim();
        ArrayList<ArrayList<Integer>> magicArray = new ArrayList<>();
        try {
            while (null != inputValue && inputValue.length() > 0) {
                ArrayList<Integer> lineArray = new ArrayList<>();
                String[] lineItem = inputValue.split(" ");
                if (lineItemCount>0 && lineItem.length!=lineItemCount) {
                    throw new Exception(String.format("数组项个数不正确，第一行个数为: %d", lineItemCount));
                }
                lineItemCount = lineItem.length;
                for (String item : lineItem) {
                    lineArray.add(Integer.parseInt(item));
                }
                magicArray.add(lineArray);
                inputValue=scanner.nextLine();
            }
            if (magicArray.size() != lineItemCount) {
                throw new Exception(String.format("数组项条数不正确，第一行个数为: %d", lineItemCount));
            }
            System.out.printf("判断结果为：%b", checkArray(magicArray));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static boolean checkArray(ArrayList<ArrayList<Integer>> magicArray) {
        int standardValue=-1;

        lineItemCount = magicArray.size();
        try {
            for (int i = 0; i < lineItemCount; i++) {
                int xSumValue = 0;
                int ySumValue = 0;
                int liSumValue = 0;
                int riSumValue = 0;
                for (int j = 0; j < lineItemCount; j++) {
                    xSumValue += magicArray.get(i).get(j);
                    ySumValue += magicArray.get(j).get(i);
                    liSumValue += magicArray.get(j).get(j);
                    riSumValue += magicArray.get(j).get(lineItemCount-1-j);
                }
                if (xSumValue!=ySumValue)
                    throw new Exception(String.format("得到的第%d行单行值为：%d,第%d列单列值为：%d，不匹配",i,xSumValue,i,ySumValue));
                if (standardValue == -1)
                    standardValue = xSumValue;
                if (standardValue != xSumValue)
                    throw new Exception(String.format("得到的第%d行单行值为：%d,标准值为：%d，不匹配",i,xSumValue,standardValue));
                if (standardValue != liSumValue)
                    throw new Exception(String.format("得到的左侧斜列值为：%d,标准值为：%d，不匹配",liSumValue,standardValue));
                if (standardValue != riSumValue)
                    throw new Exception(String.format("得到的右侧斜列值为：%d,标准值为：%d，不匹配",riSumValue,standardValue));
            }
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
