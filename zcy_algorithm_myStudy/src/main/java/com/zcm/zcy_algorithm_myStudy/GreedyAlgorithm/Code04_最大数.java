package com.zcm.zcy_algorithm_myStudy.GreedyAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Code04_最大数 {
    public static void main(String[] args) {
/*        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        int[] arr = new int[split.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.valueOf(split[i]);
        }
        System.out.println(largestNumber(arr));*/

        String s = "99999999991";
        System.out.println(Long.valueOf(s)-Long.valueOf(s));
    }


    public static String largestNumber(int[] nums) {
        int n =nums.length;
        String[] arr = new String[n];

        for(int i=0;i<n;i++){
            arr[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(arr,(x,y)->{
            String xy = x+y;
            String yx = y+x;
            return yx.compareTo(xy);
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(arr[i]);
        }

        // 处理前导0
        while(sb.length()>1 && sb.charAt(0)=='0' && sb.charAt(1) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
