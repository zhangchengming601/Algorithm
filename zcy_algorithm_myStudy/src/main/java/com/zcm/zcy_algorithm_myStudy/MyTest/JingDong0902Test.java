package com.zcm.zcy_algorithm_myStudy.MyTest;


import java.util.Arrays;
import java.util.Scanner;

public class JingDong0902Test {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String line = in.nextLine();
            String[] date = line.split(" ");
            int[] arr1 = new int[]{Integer.valueOf(date[0]) , Integer.valueOf(date[1])};
            int[] arr2 = new int[]{Integer.valueOf(date[2]) , Integer.valueOf(date[3])};
            int[] arr3 = new int[]{Integer.valueOf(date[4]) , Integer.valueOf(date[5])};
            System.out.println(process(arr1,arr2,arr3));
        }
    }

    public static int process(int[] arr1 , int[] arr2 ,int[] arr3){
        int res = -1;
        res = Math.max(res , process2(arr1,arr2));
        res = Math.max(res , process2(arr1,arr3));
        res = Math.max(res , process2(arr2,arr3));
        return res;
    }

    public static int process2(int[] arr1,int[] arr2){
        int[] array = new int[2];
        array[0] = Math.max(arr1[0],arr2[0]);
        array[1] = Math.min(arr1[1],arr2[1]);

        if (array[0]>array[1]){
            return -1;
        }
        return array[1];
    }
}
