package com.zcm.zcy_algorithm_myStudy.HashTable;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Hot03_数组中只出现一次的两个数字 {

    public int[] FindNumsAppearOnce (int[] nums) {

        int[] res = new int[2];
        int count=0;

        HashMap<Integer, Boolean> map = new HashMap<>();


        for (int i=1;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                map.remove(nums[i]);
                continue;
            }
            map.put(nums[i],true);
        }

        Iterator<Map.Entry<Integer, Boolean>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Boolean> entry = iterator.next();
            res[count++] = entry.getKey();
        }
        Arrays.sort(res);

        return res;
    }
}
