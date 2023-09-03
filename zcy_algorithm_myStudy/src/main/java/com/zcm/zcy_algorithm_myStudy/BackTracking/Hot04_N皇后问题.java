package com.zcm.zcy_algorithm_myStudy.BackTracking;

public class Hot04_N皇后问题 {

    public int Nqueen (int n) {
        if (n==1){
            return 1;
        }
        if (n<1){
            return 0;
        }
        int[] record = new int[n];
        return process(n,0,record);
    }

    /**
     * n : 表示矩阵是n行n列的
     * curRow : 表示当前来到了第curRow行
     * record : 表示之前行皇后摆放的位置
     * */
    public int process(int n , int curRow, int[] record){
        if (curRow==n){
            // 表示当前来到了最后一行，则表明当前的摆放位置成立
            return 1;
        }
        // 如果当前的没有到最后一行，则进行下面的逻辑
        // 从当前行的第一个元素开始遍历当前行的元素
        int res = 0;
        for (int i=0;i<n;i++){
            // 判断当前位置的元素是否有效
            boolean vaild = isVaild(curRow, i, record);
            if(!vaild){
                continue;
            }
            // 如果当前位置有效，则将该位置添加到record中，向下递归
            record[curRow] = i;
            res += process(n, curRow + 1, record);
        }
        return res;
    }

    public boolean isVaild(int row, int col, int[] record){
        for (int i=0;i<row;i++){
            if (col==record[i] || Math.abs(col-record[i])==Math.abs(row-i)){
                return false;
            }
        }
        return true;
    }
}
