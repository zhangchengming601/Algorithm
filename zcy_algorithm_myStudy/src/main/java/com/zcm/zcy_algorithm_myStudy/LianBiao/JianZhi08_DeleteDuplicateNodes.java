package com.zcm.zcy_algorithm_myStudy.LianBiao;


/**
 * 删除链表中重复的结点
 * https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=23450&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * */
public class JianZhi08_DeleteDuplicateNodes {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead==null) {
            return pHead;
        }

        // 创建一个结点，后指针指向头结点
        ListNode cur = new ListNode(0);
        cur.next = pHead;
        // 最终的返回值为res.next
        ListNode res = cur;

        ListNode next = pHead;

        // cur结点的，要始终保持和naxt结点的val不一样；因此当next结点为null的时候，cur结点也来到了链表的末尾
        while (next!=null) {

            // 如果next.next结点不为空，并且next和next.next结点的val是一样的，则;
            if (next.next!=null && next.val == next.next.val) {
                // 则将next结点向后移动，然后比较最新的next和next.next结点的val
                while (next.next!=null && next.next.val == next.val) {
                    next = next.next;
                }
                // 当next结点移动到和next.next结点不一样的时候；或者是next.next结点为null的时候
                // 则让cur的后指针指向next.next
                cur.next = next.next;
                // next指向最新的cur的后一结点
                next = cur.next;
                continue;
            }

            // 如果 next和next.next结点的val不一样，则cur向后移动，next向后移动
            cur = cur.next;
            next = next.next;

        }
        return res.next;
    }
}
