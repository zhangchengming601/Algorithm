package com.zcm.zcy_algorithm_myStudy.examination.meituan;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i] = in.nextInt();
        }
        //int[] arr= new int[]{1,3,4};
        System.out.println(process(arr));
    }

    public static String process(int[] arr){
        int tmp[] = new int[arr.length];
        tmp[0] = Integer.MAX_VALUE;
        for(int i=1;i< arr.length;i++){
            if(arr[i]<=arr[i-1]){
                return "No";
            }
            int num = arr[i]-arr[i-1];
            if(num>=tmp[i-1]){
                return "No";
            }
            tmp[i] = num;
        }
        return "Yes";
    }
}
