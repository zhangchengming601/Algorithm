package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;


/**
 * 题目： 跳台阶
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=23261&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 *
 * */
public class JianZhi03_JumpingSteps {

    public static int getAnswer(int n){
        return process(n);
    }


    /**
     * int n : 表示还剩n个台阶没走
     * */
    public static int process(int n){
        if (n==1) {
            // 如果只剩一个台阶，那只有一种方案了.返回1
            return 1;
        }
        if (n==2){
            // 如果只剩两个台阶了，那么只有两种方案,返回2
            return 2;
        }

        // 如果剩余台阶数量大于等于3， 假如说剩余3个台阶，那青蛙的第一跳有两个选择，一个选择是跳1级，另一个选择时跳2级
        // 当选择跳1级时，那么是不是说还剩2个台阶，是不是也就来到了只剩2个台阶的情况
        // 当选择跳2级的时候，那么是不是说还剩1个台阶，是不是也就来到了只剩1个台阶的情况

        return process(n-1) + process(n-2);
    }


    public static int processByDP(int n){
        if (n <= 2) {
            return n;
        }
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(getAnswer(7));
    }
}
