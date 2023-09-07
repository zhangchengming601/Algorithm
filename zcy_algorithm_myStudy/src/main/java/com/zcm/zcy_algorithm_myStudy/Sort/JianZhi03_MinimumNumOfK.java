package com.zcm.zcy_algorithm_myStudy.Sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 最小的K个数
 * https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=23263&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 *
 * */
public class JianZhi03_MinimumNumOfK {
    public ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input.length==0 || k==0) {
            return res;
        }

        // 构建一个大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->o2.compareTo(o1));
        // 构建k个数的大顶堆
        for (int i=0;i<k;i++) {
            queue.offer(input[i]);
        }

        for (int i =k;i<input.length;i++) {
            // 较小的元素入堆
            if (queue.peek()>input[i]){
                // 删除堆顶元素
                queue.poll();
                // 较小的元素入堆
                queue.offer(input[i]);
            }
        }
        //堆中元素取出入数组
        int[] arr = new int[k];
        for(int i=k-1;i>=0;i--){
            arr[i] = queue.poll();
        }

        for(int i=0;i<arr.length;i++){
            res.add(arr[i]);
        }
        return res;
    }
}
