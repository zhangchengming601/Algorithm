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
        yesSelect = process2(weight,value,index+1,rest-weight[index]);
        if (yesSelect != -1){
            yesSelect+=value[index];
        }
        return Math.max(noSelect,yesSelect);
    }
}
