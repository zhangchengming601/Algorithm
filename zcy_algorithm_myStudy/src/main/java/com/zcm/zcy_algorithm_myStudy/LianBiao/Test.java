package com.zcm.zcy_algorithm_myStudy.LianBiao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {

        process(n,k,1);
        return res;
    }

    /**
     * index : 表示当前来到了[1,2,,,,n]的第index个位置了
     * */
    public void  process(int n ,int k,int index){
        // 终止条件
        if(path.size() == k){
            ArrayList<Integer> list = new ArrayList<>(path);
            res.add(list);
        }

        // 递归逻辑
        for(int i=index; (n-i+1)<(k-path.size());i++){
            path.offer(i);
            //递归
            process(n,k,i+1);
            // 回溯
            path.removeLast();
        }
    }
}
