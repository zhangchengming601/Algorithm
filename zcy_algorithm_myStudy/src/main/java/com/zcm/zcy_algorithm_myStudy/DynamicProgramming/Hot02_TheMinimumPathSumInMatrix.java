package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;


/**
 * 矩阵中的最小路径和
 * https://www.nowcoder.com/practice/7d21b6be4c6b429bb92d219341c4f8bb?tpId=295&tqId=1009012&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D295
 * */
public class Hot02_TheMinimumPathSumInMatrix {
    public int minPathSum (int[][] matrix) {

        int rowL = matrix.length;
        int colL = matrix[0].length;

        // 先给第一行赋值
        for (int i=1;i<matrix[0].length;i++){
            matrix[0][i] +=matrix[0][i-1];
        }
        // 再给第一列赋值
        for (int i=1;i<matrix.length;i++) {
            matrix[i][0] += matrix[i-1][0];
        }

        for (int row = 1;row<rowL;row++){
            for(int col=1; col<colL;col++){
                matrix[row][col] += (matrix[row-1][col]<matrix[row][col-1] ? matrix[row-1][col] : matrix[row][col-1]);
            }
        }
        return matrix[rowL-1][colL-1];
    }
}
