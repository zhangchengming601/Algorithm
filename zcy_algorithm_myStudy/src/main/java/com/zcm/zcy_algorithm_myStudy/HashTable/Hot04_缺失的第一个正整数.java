package com.zcm.zcy_algorithm_myStudy.HashTable;

import java.util.HashMap;

public class Hot04_缺失的第一个正整数 {
    public int minNumberDisappeared01 (int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i=0;i<nums.length;i++){
            map.put(nums[i],true);
        }
        Boolean flag = true;
        int i =1;
        while(flag){
            if (!map.containsKey(i)){
                return i;
            }
            i++;
        }
        return 0;
    }
}
