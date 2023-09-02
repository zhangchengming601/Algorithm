package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;


/**
 * 最长回文字串
 * https://www.nowcoder.com/practice/b4525d1d84934cf280439aeecc36f4af?tpId=295&tqId=25269&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 * */
public class Hot05_LongestReturnTextString {

    /**
     * 回文子串
     * */
    public int getLongestPalindrome01 (String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        boolean[][] dp = new boolean[chars.length][chars.length];

        for(int row=chars.length-1;row>=0;row--){
            for (int col=row; col<chars.length;col++){
                if (row==col){
                    dp[row][col] = true;
                    res++;
                } else if(col>row && col-row==1 && chars[row]==chars[col]){
                    dp[row][col] = true;
                    res++;
                }else if(col>row && col-row>1 && chars[row]==chars[col] ){
                    dp[row][col] = dp[row+1][col-1];
                    if(dp[row][col]){
                        res++;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 最长回文子串
     * */
    public int getLongestPalindrome02 (String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int[][] dp = new int[chars.length][chars.length];

        for(int row=chars.length-1;row>=0;row--){
            for (int col=row; col<chars.length;col++){
                if (row==col){
                    dp[row][col] = 1;
                    res = Math.max(res,dp[row][col]);
                } else if(col>row && col-row==1 && chars[row]==chars[col]){
                    dp[row][col] = 2;
                    res = Math.max(res,dp[row][col]);
                }else if(col>row && col-row>1 && chars[row]==chars[col] ){
                    if (dp[row+1][col-1]>0){
                        dp[row][col]+=dp[row+1][col-1]+2;
                        res = Math.max(res,dp[row][col]);
                    }
                }
            }
        }
        return res;
    }

}
