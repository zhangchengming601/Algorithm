package com.zcm.zcy_algorithm_myStudy.LianBiao;


/**
 * 链表中倒数最后k个结点
 * https://www.nowcoder.com/practice/886370fe658f41b498d40fb34ae76ff9?tpId=13&tqId=1377477&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * */
public class JianZhi06_TheLastKNodes {

    public ListNode FindKthToTail (ListNode pHead, int k) {
        if (pHead==null){
            return pHead;
        }

        ListNode fast = pHead;
        for (int i=0; i<k; i++) {
            if (fast==null) {
                return null;
            }
            fast=fast.next;
        }
        while (fast!=null){
            fast=fast.next;
            pHead=pHead.next;
        }
        return pHead;
    }
}
