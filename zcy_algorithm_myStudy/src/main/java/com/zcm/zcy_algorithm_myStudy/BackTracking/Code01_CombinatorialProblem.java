package com.zcm.zcy_algorithm_myStudy.BackTracking;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合问题
 * https://leetcode.cn/problems/combinations/
 * */
public class Code01_CombinatorialProblem {

    private  List<List<Integer>> res =new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n,k,1);
        return res;
    }


    /**未剪枝*/
    public  void backTracking02(int n , int k , int startIndex){
        // 终止条件
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }

        // 递归逻辑
        for (int i=startIndex ; i<=n ; i++){
            path.add(i);
            backTracking(n,k,i+1);
            // 回溯
            path.removeLast();
        }

    }

    /**剪枝操作*/
    public  void backTracking(int n , int k , int startIndex){
        // 终止条件
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }

        // 递归逻辑
        for (int i=startIndex ; (k-path.size()<=(n-i+1)) ; i++){
            path.add(i);
            backTracking(n,k,i+1);
            // 回溯
            path.removeLast();
        }

    }


}
