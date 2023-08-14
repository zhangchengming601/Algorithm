package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;


/**
 * 背包问题
 * */
public class Code07_Knapsack {


    /**
     * 返回值 : 表示index位置之后选择的货物的最大价值
     * int[] weight , int[] value ， int bag : 货物的重量，货物的价值，背包可承受的重量
     * int index : 从左往右走到了第index货物的位置
     * int allWeight : index位置之前的已选择的货物的总重量
     * */
    public static int process(int[] weight , int[] value , int index , int allWeight , int bag){
        // 1. 终止条件
        // 1.1 如果之前选择的物品的重量已经大于背包的重量了，则说明这条选择链无效，返回-1
        if (allWeight>bag){
            return -1;
        }
        // 1.2 如果已经将物品选完了（没有物品可选了）,则返回0，（因为没有物品可选择，则说明此时的选择没有价值）
        if (index>weight.length){
            return 0;
        }

        // 2. 递归逻辑
        // 对于此时的index位置的货物，只有两种选择，要么装进背包，要么不装进背包

        // 2.1 对于index位置的货物，选择不装进背包,然后递归，计算后续货物能够产生的最大价值
        int noSelect = process(weight,value,index+1,allWeight,bag);

        // 2.2 对于index位置的货物，选择装进背包，然后递归，计算后续货物能够产生的最大价值
        int yesSelect = Integer.MIN_VALUE;
        yesSelect = process(weight,value,index+1,allWeight+weight[index],bag);
        if (yesSelect != -1){
            yesSelect+=value[index];
        }

        return Math.max(noSelect,yesSelect);
    }


    public static int process2(int[] weight , int[] value , int index , int rest){
        if (rest<0){
            return -1;
        }
        if(index==weight.length){
            return 0;
        }

        int noSelect = process2(weight,value,index+1,rest);

        int yesSelect = -1;
        int yesSelectNext = process2(weight,value,index+1,rest-weight[index]);
        if (yesSelectNext != -1){
            yesSelect = value[index] + yesSelectNext;
        }
        return Math.max(noSelect,yesSelect);
    }


    public static int dpWay(int[] weight , int[] value ,  int bag){
        int dp[][] = new int[weight.length+1][bag+1];
        dpProcess(weight,value,bag,dp);
        return dp[0][bag];
    }

    public static void dpProcess(int[] weight , int[] value , int bag, int[][] dp){
        // 1. dp的最下面的一层元素已经确定（都是0）
        // 2. 首先外层for循环表示从倒数第二层开始，逐层向上循环
        for (int index=weight.length ; index>=0 ; index--){
            // 3. 内层for循环表示：当层数确定下来以后，在这一层，从左向右遍历每个元素
            for (int rest=0 ; rest<=bag ; rest++){
                int noSelect = dp[index+1][rest];

                int yesSelect = -1;
                if (rest-weight[index] >= 0){
                    yesSelect = value[index] + dp[index+1][rest-weight[index]];
                }

                dp[index][rest] = Math.max(noSelect,yesSelect);
            }
        }
    }
}
