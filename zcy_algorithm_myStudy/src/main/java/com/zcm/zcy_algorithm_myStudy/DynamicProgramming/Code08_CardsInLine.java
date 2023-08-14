package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;


/**
 * 纸牌问题
 *
 * 题目： 给定一个整型数组arr，代表数值不同的纸牌排成一条线。玩家A和玩家B依次拿走每张纸 牌，
 * 规定玩家A先拿，玩家B后拿，但是每个玩家每次只能拿走最左或最右的纸牌，玩家A 和玩家B都绝顶聪明。
 * 请返回最后获胜者的分数。
 * */
public class Code08_CardsInLine {

    public static int win(int[] arr){
        if (arr==null || arr.length==0){
            return 0;
        }
        return Math.max(first(arr,0,arr.length-1),second(arr,0,arr.length-1));
    }

    /**
     * first函数的意义是，如果作为此时玩家作为先手，能[left....right]中获得最大的分数
     * 返回值： 就是在[left....right]中获得最大的分数
     * */
    public static int first(int[] arr, int left , int right){
        // 1. 终止条件 ： 如果此时就剩一张牌（也就是left==right），又由于此时为先手，则之间返回这张牌
        if (left==right){
            return arr[left];
        }

        // 2. 如果剩余的牌数大于等于2，则此时的先手玩家有两个选择
        // 2.1 先手玩家选择左边的牌，则接下来就该另一位玩家选牌，此时本函数的先手玩家就变成后手玩家了
        // 2.2 先手玩家选择右边的牌，则接下来就该另一位玩家选牌，此时本函数的先手玩家就变成后手玩家了

        // 本人选择左边的牌，然后加上本人作为后手玩家，在[left+1...right]上获得的最大分数
        int selectLeft = arr[left]+ second(arr,left+1,right);

        // 本人选择右边的牌，然后加上本人作为后手玩家，在[left...right-1]上获得的最大分数
        int selectRight = arr[right]+second(arr,left,right-1);

        return Math.max(selectLeft,selectRight);
    }

    /**
     * second函数的意思是，如果此时本人作为后手玩家，能在[left...right]上获得的最大分数
     * */
    public static int second(int[] arr, int left , int right){
        // 1. 终止条件 : 如果此时就剩一张牌，而本人作为后手，意味着无牌可选，则返回0
        if (left==right){
            return 0;
        }

        // 2. 如果剩余的牌数大于等于2， 此时本人作为后手，那么先手玩家肯定会在left或者right上选牌，
        // 2. 那先手玩家究竟选择left还是right，取决于先手玩家选了left或者right之后，first函数的最小值
        // 2. 因为先手玩家选了left或者right后，另一位玩家（本人）在剩余牌中能获得分数能够尽可能少（调用的first函数）

        // 2.1 如果先手选了左边的牌,则另外一位玩家（本人）在剩余牌获得的最大分数是
        int lScore = first(arr,left+1,right);
        // 2.2如果先手选了右边的牌，则另外一个玩家（本人）在剩余牌中获得的最大分数是
        int rScore = first(arr,left,right-1);

        // 先手玩家肯定会选择让对手获得分数最少的方案
        return Math.min(lScore,rScore);
    }


    public static void main(String[] args) {
        int a[]={1,100,1,90};
        System.out.println(dpWay(a));
    }


    public static int dpWay(int[] arr){
        if (arr==null || arr.length==0){
            return 0;
        }
        // 数组的长度
        int length = arr.length;

        // 定义firstDP这个二维数组，
        int firstDP[][] = new int[length][length];
        // 确定对角线上的元素
        for(int i=0 ; i<length ; i++){
            firstDP[i][i] = arr[i];
        }
        // 定义secondDP二维数组
        int secondDP[][] = new int[length][length];

        // 按照对角线，一层一层的向外给两个二维数组赋值
        for (int index=1 ; index<length ; index++){
            int row = 0;
            int col = index;
            while (row<length && col<length){
                firstDP[row][col] = Math.max((arr[row] + secondDP[row+1][col]) , (arr[col] + secondDP[row][col-1]));
                secondDP[row][col] = Math.min((firstDP[row+1][col]) , (firstDP[row][col-1]));
                row++;
                col++;
            }
        }

        return Math.max(firstDP[0][length-1],secondDP[0][length-1]);
    }
}
