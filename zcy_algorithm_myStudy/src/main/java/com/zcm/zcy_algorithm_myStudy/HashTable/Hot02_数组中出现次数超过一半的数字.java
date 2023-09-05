package com.zcm.zcy_algorithm_myStudy.HashTable;

import java.util.HashMap;

public class Hot02_数组中出现次数超过一半的数字 {

    public int MoreThanHalfNum_Solution (int[] numbers) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int len = numbers.length;

        for(int i=0;i<len;i++){

            if(map.get(numbers[i])==null){
                map.put(numbers[i],1);
            }else {
                Integer value = map.get(numbers[i]);
                map.put(numbers[i],value+1);
            }

            if(map.get(numbers[i])!=null && map.get(numbers[i])*2>len){
                return numbers[i];
            }

        }
        return 0;
    }
}
