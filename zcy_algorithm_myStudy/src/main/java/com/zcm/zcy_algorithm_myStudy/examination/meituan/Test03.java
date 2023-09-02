package com.zcm.zcy_algorithm_myStudy.examination.meituan;

import java.util.Arrays;
import java.util.HashMap;

public class Test03 {

    public static int process(int[] arr){
        HashMap<String, Boolean> map = new HashMap<>();
        int len = arr.length;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                int[] array =new int[]{arr[i],arr[j]};
                Arrays.sort(array);
                String s = String.valueOf(array[0])+String.valueOf(array[1]);
                if (!map.containsKey(s)){
                    map.put(s,true);
                }
            }
        }
        return map.size();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,4,5,1,4};
        System.out.println(process(arr));
    }
}
