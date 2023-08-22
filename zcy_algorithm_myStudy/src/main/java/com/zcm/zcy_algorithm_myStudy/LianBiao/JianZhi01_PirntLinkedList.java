package com.zcm.zcy_algorithm_myStudy.LianBiao;


import java.util.ArrayList;

/**
 * 题目：从尾到头打印链表
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=23278&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * */
public class JianZhi01_PirntLinkedList {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();

        while (listNode != null){
            list.add(listNode.val);
            listNode=listNode.next;
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int i=list.size()-1; i>=0; i--){
            res.add(list.get(i));
        }
        return res;
    }


    /**
     * 递归方法
     * */
    public static ArrayList<Integer> process(ListNode listNode){
        // 终止条件
        if (listNode==null){
            return new ArrayList<>();
        }
        if (listNode.next == null){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(listNode.val);
            return list;
        }

        // 递归
        ArrayList<Integer> arrayList = process(listNode.next);
        arrayList.add(listNode.val);
        return arrayList;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.size());
    }
}
