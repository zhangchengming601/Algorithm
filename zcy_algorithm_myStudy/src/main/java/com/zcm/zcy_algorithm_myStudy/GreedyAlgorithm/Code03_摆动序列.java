package com.zcm.zcy_algorithm_myStudy.GreedyAlgorithm;

public class Code03_摆动序列 {

    public int wiggleMaxLength(int[] nums) {

        if(nums.length==1 || nums.length==2){
            return 1;
        }

        // 当前的差值
        int curDiff = 0;
        // 前一个差值
        int preDiff = 0;
        int count=1;

        for(int i=1;i<nums.length;i++){
            // 获得当前的差值
            curDiff = nums[i]-nums[i-1];

            // 是否满足满足交替正负
            if((preDiff>0 && curDiff<=0) || (preDiff<=0 && curDiff>0)){
                preDiff = curDiff;
                count++;
            }
        }
        return count;
    }
}
