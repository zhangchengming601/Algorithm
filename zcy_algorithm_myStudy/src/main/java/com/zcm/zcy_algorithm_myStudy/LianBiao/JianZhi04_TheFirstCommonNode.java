package com.zcm.zcy_algorithm_myStudy.LianBiao;


/**
 * 两个链表的第一个公共结点
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=23257&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * */
public class JianZhi04_TheFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null || pHead2==null) {
            return null;
        }

        // 链表1的长度
        ListNode cur = pHead1;
        int length1 = 0;
        while (cur!=null){
            length1++;
            cur=cur.next;
        }

        // 链表2的长度
        cur = pHead2;
        int length2 = 0;
        while (cur!=null){
            length2++;
            cur=cur.next;
        }

        if (length1>length2) {
            for (int i=0; i<length1-length2;i++){
                pHead1=pHead1.next;
            }
        } else {
            for (int i=0; i<length2-length1;i++){
                pHead2=pHead2.next;
            }
        }

        while (pHead1!=null && pHead2!=null && pHead1.val != pHead2.val) {
            pHead1=pHead1.next;
            pHead2=pHead2.next;
        }
        return pHead1;

    }
}
