package com.sschen.java.base;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CreateMagicArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入想要得到的数组阶数：");
        int standardValue = scanner.nextInt();
        int lineItemCount = standardValue * standardValue;
        long maxCombineCount= lineItemCount * lineItemCount;
        ArrayList<Integer> allItem = new ArrayList<Integer>();
        for (int i = 1; i<= lineItemCount; i++) {
            allItem.add(i);
        }
        ArrayList<String> succArray = new ArrayList<>();
        ArrayList<String> failArray = new ArrayList<>();
        while (succArray.size()+failArray.size()<maxCombineCount){
            ArrayList<ArrayList<Integer>> magicArray;
            boolean succExists;
            boolean failExists;
            do {
                magicArray=getMagicArray(standardValue,allItem);
                succExists=succArray.contains(magicArray.toString());
                failExists=failArray.contains(magicArray.toString());
            } while (succExists&&failExists);
            System.out.println("校验参数为：" + magicArray.toString());
            if(MagicArray.checkArray(magicArray)){
                succArray.add(magicArray.toString());
            } else {
                failArray.add(magicArray.toString());
            }
        }
        for (String arr:
             succArray) {
            System.out.println(arr);
        }
    }

    public static ArrayList<ArrayList<Integer>> getMagicArray(int standardValue, ArrayList<Integer> allItem) {
        ArrayList<ArrayList<Integer>> magicArray = new ArrayList<>();
        ArrayList<Integer> copyArray = (ArrayList<Integer>) allItem.clone();
        for(int i = 0; i < standardValue; i++) {
            ArrayList<Integer> itemArray = new ArrayList<>();
            for(int j = 0; j < standardValue; j++) {
                int randIndex;
                do {
                    Random random= new Random();
                    randIndex = random.nextInt(copyArray.size());
                } while (randIndex >= copyArray.size());
                itemArray.add(copyArray.get(randIndex));
                copyArray.remove(randIndex);
            }
            magicArray.add(itemArray);
        }
        return magicArray;
    }
}
