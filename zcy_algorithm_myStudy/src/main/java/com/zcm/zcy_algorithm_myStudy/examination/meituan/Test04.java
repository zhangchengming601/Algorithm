package com.zcm.zcy_algorithm_myStudy.examination.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Test04 {

//    public static int process(int[] arr){
//        int maxValue = 0;
//        int maxVauleCount=0;
//        for(int i=0;i<arr.length;i++){
//            if (arr[i]==maxValue){
//                maxVauleCount++;
//            }
//            if(arr[i]>maxValue){
//                maxValue=arr[i];
//                maxVauleCount=1;
//            }
//        }
//        int firstNum = arr[0];
//        int res = 0;
//        if (maxVauleCount==1){
//            while(firstNum<maxValue){
//                res++;
//                firstNum=firstNum*2;
//            }
//        }else{
//            while
//        }
//    }

    public static int process(int[] arr){
        if (arr.length==1){
            return 0;
        }
        int firstNum = arr[0];
        int count = 0;

        Arrays.sort(arr);
        while (firstNum<arr[arr.length-1]){
            if (arr[arr.length-1] == arr[arr.length-2]){
                firstNum=firstNum*2;
                count++;
            }else {
                arr[arr.length-1] = arr[arr.length-1]/2;
                Arrays.sort(arr);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num =in.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i]=in.nextInt();
        }

//        int[] arr= new int[]{1,2,3,4};
        System.out.println(process(arr));
    }

//    public static int process(int[] arr){
//        if (arr.length==1){
//            return 0;
//        }
//        int firstNum = arr[0];
//        int count = 0;
//
//        Arrays.sort(arr);
//        if (arr[arr.length-1] == arr[arr.length-2]) {
//            while (firstNum<arr[arr.length-1]) {
//                firstNum=firstNum*2;
//                count++;
//            }
//        }else{
//            while(firstNum<arr[arr.length-1]){
//                arr[arr.length-1] = arr[arr.length-1]/2;
//                Arrays.sort(arr);
//                count++;
//            }
//        }
//        return count;
//    }
}
