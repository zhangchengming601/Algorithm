package com.zcm.zcy_algorithm_myStudy.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Hot02_有重复项数字的全排列 {

    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path =new LinkedList<>();
    public ArrayList<ArrayList<Integer>> permuteUnique (int[] num) {
        Arrays.sort(num);
        int[] used = new int[num.length];
        backTracking(num,used);
        return res;
    }

    public void backTracking(int[] num,int[] used){
        // 终止条件
        if (path.size()==num.length){
            ArrayList<Integer> list = new ArrayList<>(path);
            res.add(list);
        }

        // 递归逻辑
        for (int i=0;i<num.length;i++){
            if (used[i]==1){
                continue;
            }
            // 如果该元素没有使用过
            path.add(num[i]);
            used[i] = 1;
            // 递归
            backTracking(num,used);
            // 回溯
            path.removeLast();
            used[i]=0;
            while(i<num.length-1 && num[i+1]== num[i]){
                i++;
            }

        }
    }
}
