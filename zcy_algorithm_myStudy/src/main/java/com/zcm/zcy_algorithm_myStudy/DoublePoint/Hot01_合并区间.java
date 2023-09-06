package com.zcm.zcy_algorithm_myStudy.DoublePoint;

import sun.jvm.hotspot.utilities.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Hot01_合并区间 {
    public int[][] merge(int[][] intervals) {
        // 对这个数组进行排序  (根据区间的开始节点排序)
        Arrays.sort(intervals,(arr1,arr2)->{
            return arr1[0]-arr2[0];
        });

        ArrayList<int[]> res = new ArrayList<>();

        // 将第一个区间先加进res中
        res.add(intervals[0]);
        // count用来记录res集合中最后一个元素的索引
        int count=0;

        for(int i=1;i<intervals.length;i++){
            // 先获得res集合中最后一个元素（区间）
            int[] orgin = res.get(count);
            // 比较当前区间的开始节点和res集合中最后一个区间的终止节点的大小
            if (intervals[i][0]>orgin[1]){
                // 如果当前区间的开始节点大于orgin的终止节点---说明此时两个区间不重合，则将当前区间假如到res中，更新count
                res.add(intervals[i]);
                count++;
            }else {
                // 如果当前区间的开始节点小于orgin区间的终止节点---说明两个区间有重合，则先移除res中的最后一个元素
                res.remove(count);

                // 当是[30,60] , [40,50]的时候，跳过下面if语句
                // 当是[30,60] , [40,70]的时候，进入下面if语句
                if (orgin[1]<intervals[i][1]){
                    orgin[1]= intervals[i][1];
                }
                // 将新的orgin添加到res中
                res.add(orgin);
            }
        }
        // 将List集合转为数组
        int[][] resArray = res.toArray(new int[res.size()][]);
        return resArray;
    }
}
