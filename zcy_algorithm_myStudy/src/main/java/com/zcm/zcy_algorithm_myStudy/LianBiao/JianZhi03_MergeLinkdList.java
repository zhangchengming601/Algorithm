package com.zcm.zcy_algorithm_myStudy.LianBiao;


/**
 * 合并两个排序的链表
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=23267&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * */
public class JianZhi03_MergeLinkdList {

    public ListNode Merge (ListNode pHead1, ListNode pHead2) {
        if (pHead1==null && pHead2!=null){
            return pHead2;
        }
        if (pHead2==null && pHead1!=null){
            return pHead1;
        }

        // 1. 让head节点指向两个链表头节点中最小的那个
        ListNode head = null;
        if (pHead1.val<pHead2.val) {
            head = pHead1;
            pHead1 = pHead1.next;
        } else {
            head = pHead2;
            pHead2= pHead2.next;
        }


        ListNode cur = head;
        while (pHead1!=null || pHead2!=null){
            // 2. 如果pHead1或者pHead2此时有一个为null，则直接让cur只想剩下那个不为空的
            if (pHead1 == null) {
                cur.next = pHead2;
                break;
            } else if (pHead2 ==null) {
                cur.next = pHead1;
                break;
            }

            // 3. 如果此时pHead1和pHead2都不为空，则cur下一个指向就是两个pHead1和pHead2中值最小的那个
            if (pHead1.val<pHead2.val) {
                cur.next = pHead1;
                cur = pHead1;
                pHead1 = pHead1.next;
            } else {
                cur.next = pHead2;
                cur = pHead2;
                pHead2 = pHead2.next;
            }
        }
        return head;
    }
}
