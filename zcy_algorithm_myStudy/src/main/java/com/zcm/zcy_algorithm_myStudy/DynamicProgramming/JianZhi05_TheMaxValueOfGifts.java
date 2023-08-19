package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;


/**
 * 题目：礼物的最大价值
 * https://www.nowcoder.com/practice/2237b401eb9347d282310fc1c3adb134?tpId=13&tqId=2276652&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 *
 * */
public class JianZhi05_TheMaxValueOfGifts {

    public static int processByDp(int[][] grid){
        int M = grid.length;
        int N = grid[0].length;
        int dp[][] = new int[M][N];
        dp[M-1][N-1] = grid[M-1][N-1];
        // 先给最后一行和最后一列赋值
        for (int i=N-2; i>=0; i--){
            dp[M-1][i] = grid[M-1][i] + dp[M-1][i+1];
        }
        for (int i=M-2; i>=0; i--){
            dp[i][N-1] = grid[i][N-1] + dp[i+1][N-1];
        }

        for (int row=M-2; row>=0; row--) {
            for (int col=N-2; col>=0; col--)
                dp[row][col] = grid[row][col] + Math.max(dp[row+1][col] , dp[row][col+1]);
        }
        return dp[0][0];
    }

}
