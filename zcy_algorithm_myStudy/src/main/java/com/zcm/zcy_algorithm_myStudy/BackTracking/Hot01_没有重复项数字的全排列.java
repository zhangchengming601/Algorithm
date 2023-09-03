package com.zcm.zcy_algorithm_myStudy.BackTracking;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hot01_没有重复项数字的全排列 {

    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public ArrayList<ArrayList<Integer>> permute (int[] num) {
        int[] used = new int[num.length];
        backTracking(num.length,used,num);
        return res;
    }

    /**
     * len : 数组的长度
     * int[] used ： 标记num数组中哪些位置的元素已经使用了 ，使用了的位置标记为1，未使用的标记为0；
     *
     * */
    public void backTracking(int len, int[] used, int[] num){
        // 终止条件
        if (path.size()==len){
            ArrayList<Integer> list = new ArrayList<>(path);
            res.add(list);
        }

        // 递归逻辑
        for (int i=0;i<num.length;i++){
            if(used[i]!=1){
                // 如果该元素没有使用过，则将该元素添加到path中，并该该位置标记为已使用
                path.add(num[i]);
                used[i] = 1;
                // 递归
                backTracking(len,used,num);
                //回溯
                path.removeLast();
                used[i] = 0;
            }
        }
    }
}
