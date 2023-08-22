package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;


import java.util.Arrays;

/**
 * 题目：把数字翻译成字符串
 * https://www.nowcoder.com/practice/046a55e6cd274cffb88fc32dba695668?tpId=13&tqId=1024831&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * */
public class JianZhi07_TrranslateNumbersIntoStrings {

    public static int processByDP(String nums){
        // 1. 排除特殊情况
        // 1.1 当字符串为 "0" 或者是 "0123"这种时
        if (nums=="0" || nums.charAt(0)=='0'){
            return 0;
        }
        // 1.2 当字符串为 "10" 或者是 "20" 时
        if (nums=="10" || nums=="20"){
            return 1;
        }
        // 1.3 当字符串的长度是1时，并且该字符串不等于"0" 时
        if (nums.length()==1){
            return 1;
        }

        // 2. 动态规划
        int dp[] = new int[nums.length()];
        // 2.1 dp[0]表示字符串中首字母的可以组成一个转换
        dp[0] = 1;
        // 2.2 给dp[1] 进行赋值，如果字符串的前两个字符是 11-19 或者是21-26  则dp[1]=2 ; 否则dp[1]=1
        if((nums.charAt(0)=='1' && nums.charAt(1)<='9' && nums.charAt(1)>'0') || (nums.charAt(0)=='2' && nums.charAt(1)<'7' && nums.charAt(1)>'0')){
            dp[1] = 2;
        }else {
            dp[1] = 1;
        }

        for (int i=2; i<nums.length(); i++) {
            // 前一个字符
            char pre = nums.charAt(i - 1);
            // 当前字符
            char cur = nums.charAt(i);
            // 如果在字符串中出现 30，40，50.。。。。这样的，直接返回0
            if (cur=='0' && (pre!='1' && pre!='2')){
                return 0;
            }

            if ((pre == '1' && (cur > '0' && cur <= '9')) || (pre == '2' && (cur > '0' && cur < '7'))) {
                // 如果pre和cur组合起来是为11-19，21-26 之间的数，则当前的dp[i] = dp[i-1] + dp[i-2]
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[nums.length()-1];
    }



    public static void main(String[] args) {
        String numc = "72910721221427251718216239162221131917242";
        String nums = "11";
        System.out.println(processByDP(nums));

    }
}
