package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;


/**
 * 题目： 买股票的最佳时机
 * https://www.nowcoder.com/practice/64b4262d4e6d4f6181cd45446a5821ec?tpId=13&tqId=625&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * */
public class JianZhi04_BuyingStocks {

    /**
     * dp[i][j] 表示第i天买进，第j天卖出的利润
     * */
    public static int processByDP(int[] prices){
        int N = prices.length;
        int dp[][] = new int[N][N];
        int maxValue = 0;

        for (int row=0; row<N; row++){
            for (int col=row+1; col<N; col++){
                dp[row][col] = prices[col] - prices[row];
                maxValue = (dp[row][col]>0 && dp[row][col]>maxValue) ? dp[row][col] : maxValue;
            }
        }
        return maxValue;
    }
}
