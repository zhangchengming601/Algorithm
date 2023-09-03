package com.zcm.zcy_algorithm_myStudy.BackTracking;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code02_组合总和 {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n,k,1);
        return res;
    }

     public void backTracking(int n,int k , int startIndex){
        // 终止条件
         int sum = 0;
         for (int i=0;i<path.size();i++){
             sum+=path.get(i);
         }
         if (sum == n && path.size()==k){
             ArrayList<Integer> list = new ArrayList<>(path);
             res.add(list);
         }
         if (sum>n || (sum==n && path.size()!=k) || startIndex>9){
             return;
         }

         // 递归逻辑
         for (int i=startIndex; (k-path.size()<=(9-i+1));i++){
             path.add(i);
             // 递归
             backTracking(n,k,i+1);
             // 回溯
             path.removeLast();
         }

     }
}
