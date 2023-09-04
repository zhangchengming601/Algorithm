package com.zcm.zcy_algorithm_myStudy.GreedyAlgorithm;

public class Code02_分发糖果 {

    public int candy(int[] ratings) {

        int[] num = new int[ratings.length];
        num[0]=1;

        // 先从左向右，比较右节点比左节点大的情况
        for (int i=1;i<ratings.length;i++){

            if (ratings[i]>ratings[i-1]){
                // 如果右节点比左节点大，则右节点的得分比左节点大一个
                num[i]=num[i-1]+1;
            }else {
                // 如果右节点小于等于左节点，则右节点得1分
                num[i]=1;
            }
        }

        // 再从右向左比较左节点比右节点大的情况
        for (int i=ratings.length-2;i>=0;i--){

            if (ratings[i]>ratings[i+1] && num[i]<=num[i+1]){
                // 如果左节点大于右节点，并且左节点的得分小于右节点，则左节点的得分比右节点大一个
                num[i]=num[i+1]+1;
            }
        }

        int res = 0;
        for(int i=0;i<num.length;i++){
            res+=num[i];
        }
        return res;
    }
}
