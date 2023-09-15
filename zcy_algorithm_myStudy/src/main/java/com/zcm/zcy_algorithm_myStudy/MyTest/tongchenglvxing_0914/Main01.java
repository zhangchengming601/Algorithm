package com.zcm.zcy_algorithm_myStudy.MyTest.tongchenglvxing_0914;

import java.util.Arrays;

public class Main01 {


    public static void main(String[] args) {
        int[] arr = new int[]{1200,600,1000,800};
        Main01 main01 = new Main01();
        int[] res = main01.quickSort(arr);
        Arrays.stream(res).forEach(a-> System.out.println(a));
    }

    public int[] quickSort (int[] arr) {
        process(arr,0,arr.length-1);
        int[] res = new int[arr.length];
        int n = arr.length;
        for(int i=0;i<n;i++){
            res[i] = arr[n-i-1];
        }
        return res;
    }

    public static void process(int[] arr ,int leftIndex,int rightIndex){
        if(leftIndex>=rightIndex){
            return;
        }

        int left = leftIndex;
        int right = rightIndex;

        int key = arr[left];

        while(left<right){
            while(right>left && arr[right]>=key){
                right--;
            }

            arr[left] = arr[right];
            while(left<right && arr[left] <= key){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        process(arr,right+1,rightIndex);
        process(arr,leftIndex,left-1);

    }
}
