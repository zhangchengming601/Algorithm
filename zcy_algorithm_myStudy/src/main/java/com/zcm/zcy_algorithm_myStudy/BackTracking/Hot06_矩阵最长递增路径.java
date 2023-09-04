package com.zcm.zcy_algorithm_myStudy.BackTracking;

public class Hot06_矩阵最长递增路径 {

    private int res = 0;
    public int solve (int[][] matrix) {

        // 逐个遍历矩阵中的元素
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length;col++){
                process(matrix,row,col,0,-1);
            }
        }
        return res;
    }

    public void process(int[][] matrix, int row , int col, int pathLen , int num){

        // 如果越界，或者不满足递增条件，则比较此时的路径长度，并结束递归
        if (row<0 || row>=matrix.length || col<0 || col>=matrix[0].length || matrix[row][col]==-1 || matrix[row][col]<=num){
            res = Math.max(res,pathLen);
            return;
        }
        // 记录当前的值，便于后面回溯
        int curNum = matrix[row][col];

        // 单层递归逻辑
        // 先将当前节点改为-1
        matrix[row][col]=-1;
        // 向上递归
        process(matrix,row-1,col,pathLen+1,curNum);
        // 向下递归
        process(matrix,row+1,col,pathLen+1,curNum);
        // 向左递归
        process(matrix,row,col-1,pathLen+1,curNum);
        // 向右递归
        process(matrix,row,col+1,pathLen+1,curNum);

        // 回溯
        matrix[row][col] = curNum;

    }
}
