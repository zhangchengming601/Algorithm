package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;

public class Code09_NQueens {


    /**
     * int[] record : 之前皇后的摆放位置，其中数组中记录的是之前每一行皇后对应的y坐标
     * int x : x表示当前来到了第x行
     * int n : n表示一共有n行
     *
     * 返回值 : int 表示当前行之后有多少种成立的方案
     * */
    public static int process(int[] record , int x , int n){
        // 终止条件
        if (x==n){
            // 如果当前来到了x行，并且x==n ; 说明所有行已经走完了，那么也就说明该方案的摆放成立
            return 1;
        }

        // 递归逻辑
        int res = 0;
        // 遍历当前行每一列是否能作为皇后摆放的位置
        for (int y=0 ; y<n ; y++){
            boolean vaild =isVaild(record,x,y);
            if (!vaild){
                continue;
            }
            // 如果当前(x,y)和之前每个皇后的位置不冲突，则把(x,y)作为一种备选坐标进行向下递归
            record[x] = y;
            res += process(record,x+1,n);
        }
        return res;
    }

    /**
     * 判断当前位置(x,y)是否可以作为皇后的摆放位置
     * */
    private static boolean isVaild(int[] record , int x , int y){
        // 遍历之前每个皇后的摆放位置是否和当前(x,y)位置有冲突
        // 1. 纵坐标不能冲突 ； 2. 斜线不能冲突（斜率）
        for (int i =0 ; i<x ; i++){
            if (record[i]==y || (Math.abs(y-record[i]) == Math.abs(x-i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int n=8;
//        int record[]=new int[n];
//        System.out.println(process(record,0,n));
        System.out.println(num(8));
    }

    public static int num(int n){
         if (n<1 || n>32){
             return 0;
         }

         // limit是一个int型整数，用二进制表示的话，就是32位
         // 如果是一个8皇后问题，我们需要二进制limit的最右侧的八位全是1，剩余位都是0  (000....00011111111)
         // 如果是一个13皇后问题，我们需要二进制limit的最右侧的13位全是1，剩余位都是0
         int limit = n==32 ? -1 : (1<<n)-1;
         return process2(limit,0,0,0);
    }

    /**
     * 1 的位置表示不能放皇后，0 的位置表示可以放皇后
     * int limit : 表示总限制（也可以认为是问题的规模），limit固定不变
     * int colLim : 表示列限制
     * int leftDiaLim : 表示左斜线限制
     * int rightDiaLim : 表示右斜线限制
     * 返回值 : 表示该行可行的方案有多少种
     * */
    public static int process2(int limit,
                               int colLim,
                               int leftDiaLim,
                               int rightDiaLim){
        // 终止条件
        if(colLim == limit){
            // 当二进制colLim和二进制limit相等的时候，也就说明最后一行已经走完了，那么也就说明当前方案可行
            return 1;
        }

        // 递归逻辑
        // 当前行，所有候选皇后的位置表示位pos
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0){
            // mostRightOne表示在pos上，只保留最右侧的1，其余位置都是0
            mostRightOne = pos & (~pos + 1);
            // 将pos上最右侧的1变为0 ， pos上其余位置元素不变
            pos = pos - mostRightOne;

            // 递归
            // 列限制：就是我之前的列限制，然后或上现在的mostRightOne ，就是此时的列限制
            // 左斜线限制： 就是之前的左斜线限制，然后或上现在的mostRightOne，然后再整体左移1位
            // 右斜线限制： 就是之前的右斜线限制，然后或上现在的mostRightOne，然后再整体右移1位
            res += process2(limit,
                    colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>>1);
        }
        return res;
    }
}
