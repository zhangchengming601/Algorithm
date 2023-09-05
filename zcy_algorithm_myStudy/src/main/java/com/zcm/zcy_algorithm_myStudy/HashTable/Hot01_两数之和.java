package com.zcm.zcy_algorithm_myStudy.HashTable;

import java.util.HashMap;

public class Hot01_两数之和 {

    public int[] twoSum (int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for(int i=0;i<numbers.length;i++){
            if (map.containsKey(target-numbers[i])){
                res[0] = map.get(target-numbers[i]) < i ? map.get(target-numbers[i])+1: i+1;
                res[1] = map.get(target-numbers[i]) < i ? i+1 : map.get(target-numbers[i])+1;
                return res;
            }
            map.put(numbers[i],i);
        }
        return res;
    }
}
