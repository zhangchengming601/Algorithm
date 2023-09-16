package com.zcm.zcy_algorithm_myStudy.MyTest.haoweilai_0915;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] split = in.nextLine().split(",");
        int[] arr = new int[split.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.valueOf(split[i]);
        }
        int k = Integer.valueOf(in.nextLine());
        int[] res = process(arr, k);

        System.out.print("[");

        for(int i=0;i<res.length;i++){
            if(i==res.length-1){
                System.out.print(res[i] + "]");
                break;
            }
            System.out.print(res[i]+" ");

        }
    }

    public static int[] process(int[] arr , int k){
        // 构建小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->{
            return o1-o2;
        });

        for(int i=0;i<arr.length;i++){
            queue.offer(arr[i]);
        }

        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] =queue.poll();
        }


        return res;
    }
}
