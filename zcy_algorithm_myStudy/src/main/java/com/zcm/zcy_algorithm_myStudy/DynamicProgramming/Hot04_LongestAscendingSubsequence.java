package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 最长上升子序列(一)
 * https://www.nowcoder.com/practice/5164f38b67f846fb8699e9352695cd2f?tpId=295&tqId=2281434&ru=/exam/company&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Fcompany
 * */
public class Hot04_LongestAscendingSubsequence {

    public static int process (int[] arr) {
        if (arr.length==0 || arr==null){
            return 0;
        }
        // dp[i] 表示 arr[0.....i]上的最长上升子序列的长度
        int[] dp = new int[arr.length];
        Arrays.fill(dp,1);
        dp[0]=1;
        int res =1;

        // 从 arr[1......N]逐个遍历
        for (int i=1;i<arr.length;i++){
            // 从arr[0....i-1] 比较arr[i]和arr[j] 的大小，如果arr[i]>arr[j] 说明arr[i]可以成为arr[j]上升子序列的下一个
            for (int j=0; j<i; j++){
                if (arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            // 尝试更新最大的上升子序列
            res = Math.max(res,dp[i]);
        }
        return res;

    }


    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String s = in.nextLine();
        String[] strings = s.split(" ");
        int[] arr = new int[strings.length];
        for (int i=0;i<strings.length;i++){
            arr[i] = Integer.valueOf(strings[i]);
        }
        System.out.println(process(arr));

    }
}
