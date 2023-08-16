package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;






/**
 * 最长公共子序列  https://leetcode.cn/problems/qJnOS7/
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * */
public class Code13_LongestCommonSubseqquence {
    public static int process(String str1 , String str2){
        int[][] dp = new int[str1.length()][str2.length()];

        char[] strArr1 = str1.toCharArray();
        char[] strArr2 = str2.toCharArray();

        // 给dp[0][0]赋值
        dp[0][0] = (strArr2[0] == strArr1[0] ? 1 : 0);

        // 给第一行赋值
        // 第一行表示 str1[0] 位置已经确定下来了，枚举str2[1...N]是否和str1[0]有最长公共子序列
        for (int i=1 ; i<strArr2.length ; i++){
            dp[0][i] = (dp[0][i-1]>0 ? dp[0][i-1] : (strArr2[i] == strArr1[0] ? 1 : 0));
        }
        // 给第一列赋值
        // 第一列表示 str2[0] 位置已经确定下来了，枚举str1[1...N]是否和str2[0]有最长公共子序列
        for (int i=1 ; i<strArr1.length ; i++){
            dp[i][0] = (dp[i-1][0]>0 ? dp[i-1][0] : (strArr1[i] == strArr2[0] ? 1 :0));
        }

        // 给其他位置元素赋值  dp[i][j]  i>1  j>1
        for (int i=1 ;i<strArr1.length;i++){
            for (int j=1 ; j<strArr2.length ; j++){
                // 枚举最长公共子序列可能出现的四种情况
                // 情况2和情况3
                dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
                // 情况4
                if (strArr1[i] == strArr2[j]){
                    dp[i][j] = Math.max(dp[i][j] , 1+dp[i-1][j-1]);
                }
            }
        }
        return dp[str1.length()-1][str2.length()-1];
    }
}
