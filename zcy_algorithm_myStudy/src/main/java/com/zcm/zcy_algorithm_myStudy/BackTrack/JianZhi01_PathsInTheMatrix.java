package com.zcm.zcy_algorithm_myStudy.BackTrack;


/**
 * 矩阵中的路径
 * https://www.nowcoder.com/practice/2a49359695a544b8939c77358d29b7e6?tpId=13&tqId=1517966&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * */
public class JianZhi01_PathsInTheMatrix {

    public boolean hasPath (char[][] matrix, String word) {
        char[] words = word.toCharArray();


        // 核心思想就是说我要逐个遍历二维数组中的每个元素，看从每个元素出发，能否构成word
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (dfs(matrix,i,j,words,0)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * int row ：矩阵的横坐标
     * int col： 矩阵的纵坐标
     * int index： 遍历到woed数组中的第index个元素了
     * */
    public static boolean dfs(char[][] matrix, int row, int col, char[] word, int index){
        // 终止条件
        // 1. 超过边界 ； 2. index大于等于word的长度； 3. matrix的当前元素和word[index]不一样  则返回false
        if (row<0 || row>=matrix.length || col<0 || col>matrix[0].length || index>=word.length || matrix[row][col]!=word[index]){
            return false;
        }
        if (index==word.length-1) {
            return true;
        }
        // 记录当前元素，方便后面恢复
        char tmp = matrix[row][col];
        matrix[row][col] = '.';

        // 向上
        boolean res = (dfs(matrix,row-1,col,word,index+1)
                || dfs(matrix,row+1,col,word,index+1)
                || dfs(matrix,row,col-1,word,index+1)
                || dfs(matrix,row,col+1,word,index+1));
        // 恢复
        matrix[row][col] = tmp;
        return res;
    }
}

