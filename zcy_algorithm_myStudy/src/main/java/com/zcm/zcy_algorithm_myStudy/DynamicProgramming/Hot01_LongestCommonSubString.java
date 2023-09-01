package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;


/**
 * 最长公共字串
 * https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac?tpId=295&tqId=991150&ru=/exam/company&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Fcompany
 * */
public class Hot01_LongestCommonSubString {
    public String process (String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int maxLength = 0; // 记录最长字串的长度
        int maxIndex = 0; // 记录最长字串的最后一个字符的位置

        int rowL = str1.length();
        int colL = str2.length();
        // dp[i][j] : 表示已str1第i个字符结尾和以str2的第j个字符结尾的最长公共字串
        int[][] dp = new int[rowL][colL];
        // 给第一行和第一列赋值
        for (int i=0;i<colL;i++){
            if(arr1[0] == arr2[i]){
                dp[0][i] = 1;
            }
        }
        for (int i=0;i<rowL;i++){
            if(arr2[0]==arr1[i]){
                dp[i][0] = 1;
            }
        }

        for (int row=1;row<rowL;row++){
            for (int col=1;col<colL;col++){

                if (arr1[row]==arr2[col]){
                    // 如果arr1[row]==arr2[col] 则需要考虑dp[row-1][col-1]
                    dp[row][col] =dp[row-1][col-1]+1;
                    // 判断更新maxLength和maxIndex
                    if (dp[row][col]>maxLength) {
                        maxLength = dp[row][col];
                        maxIndex = row;
                    }
                } else {
                    // 如果arr1[row]和arr2[col] 不相等，则 dp[row][col] = 0;
                    dp[row][col] = 0;
                }
            }
        }
        return str1.substring(maxIndex-maxLength+1,maxIndex);
    }
}
