package com.zcm.zcy_algorithm_myStudy.LianBiao;


/**
 * 反转链表
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=23286&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * */
public class JianZhi02_ReverseLinkedList {

    public ListNode ReverseList (ListNode head) {
        // 创建一个虚拟头节点
        ListNode cur = head;
        ListNode node = null;

        while (cur != null) {
                ListNode next = cur.next;
                cur.next = node;
                node = cur;
                cur = next;
        }
        return node;
    }
}
