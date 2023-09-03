package com.zcm.zcy_algorithm_myStudy.BackTracking;

public class Hot03_岛屿数量 {
    public int solve (char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int res = 0;
        for (int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                int num = dfs(grid, i, j);
                if (num>1){
                    res++;
                }
            }
        }
        return res;
    }

    public int dfs(char[][] grid ,int row,int col){
        // 终止条件
        if (row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]=='0'){
            return 0 ;
        }
        grid[row][col]='0';

        // 深度搜索
        int res=1;
        res+=dfs(grid,row-1,col);
        res+=dfs(grid,row+1,col);
        res+=dfs(grid,row,col-1);
        res+=dfs(grid,row,col+1);

        return res;

    }
}
