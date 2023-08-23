package com.zcm.zcy_algorithm_myStudy.LianBiao;


import com.zcm.zcy_algorithm_myStudy.Tree.TreeNode;

/**
 * 链表中环的入口结点
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=23449&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * */
public class JianZhi05_TheEntryNode {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead==null){
            return null;
        }

        ListNode slow = pHead;
        ListNode fast = pHead;

        while (fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;

            // 表示有环
            if (fast==slow) {
                while (slow!=pHead) {
                    pHead=pHead.next;
                    slow=slow.next;
                }
                return pHead;
            }
        }
        return null;
    }
}
