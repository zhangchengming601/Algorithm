package com.zcm.zcy_algorithm_myStudy.QueueAndStack;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 * https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=23458&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * */
public class JianZhi03_MaximumValueOfSlidingWindow {
    public ArrayList<Integer> maxInWindows (int[] num, int size) {

        if (size==0 || num.length==0 || num.length<size){
            return new ArrayList();
        }

        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        // 先把前size个元素按照降序规则放入队列中
        for (int i=0; i<size; i++) {
            // 如果队尾元素小于此时的num[i]；则先将队尾元素移除，再将num[i]添加到队尾
            while(deque.size()>0 && num[i]>deque.getLast()) {
                deque.removeLast();
            }
            deque.add(num[i]);

        }
        // 此时队列中的队头就是第一个滑动窗口的最大值
        res.add(deque.getFirst());

        for (int i=1; i<num.length-size+1; i++){
            // 如果滑动窗口移除的元素在队头，则将队头元素删除，否则队列不变
            if (num[i-1] == deque.getFirst()) {
                deque.pop();
            }

            // 当前新加进来的元素
            int number = num[i+size-1];

            // 将新加进来的元素试图放进队列（按照队列递减原则）
            while (deque.size()>0 && number>deque.getLast()) {
                // 如果新加进来的元素大于队尾元素，则移除队尾元素
                deque.removeLast();
            }
            deque.add(number);
            // 此时的队头就是当前滑动窗口的最大值
            res.add(deque.getFirst());
        }
        return res;
    }


    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        System.out.println(deque.getFirst());
    }
}
