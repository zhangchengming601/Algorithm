package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;



/**
 * 题目：连续子数组的最大和
 * 牛客链接 ：https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=23259&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * */
public class JianZhi01_MaximumSumOfContinuousSubarrays {

    /**
     * 使用贪心算法获得答案
     * */
    public static int getAnswerByGreedy(int[] array){
        // 定义一个变量来记录 最大和
        int maxSum = array[0];

        // 定义一个变量，记录单个子问题的记录和
        int sum = array[0];

        for (int index=1; index<array.length; index++){
            // 如果index之前的子数组的和已经小于0了，那么sum就从index作为起点
            if (sum <= 0){
                sum = array[index];
            }else {
                sum +=array[index];
            }
            // 如果在子数组的和此时已经大于了之前记录的最大和的值，则将最大和的值替换为目前子数组的和
            if (sum>maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }

    /**
     * 使用动态规划
     *
     * 2. dp[i] 表示来到数组中第i个元素（包括i）时，当前子数组的和
     * 3. 当前字数组：起始位置并不一定是array[0] ，而是看之前是否出现过dp[i]<0的情况
     * */
    public static int getAnswerByDP(int[] array){
        int dp[] = new int[array.length];
        dp[0] = array[0];
        int result =array[0];
        for (int index=1; index<array.length; index++){
            dp[index] = dp[index-1]<=0 ? array[index] : dp[index-1]+array[index];
            if (result<dp[index]) {
                result = dp[index];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] array = {1,-2,3,10,-4,7,2,-5};
        System.out.println(getAnswerByGreedy(array));
        System.out.println(getAnswerByDP(array));
    }
}
