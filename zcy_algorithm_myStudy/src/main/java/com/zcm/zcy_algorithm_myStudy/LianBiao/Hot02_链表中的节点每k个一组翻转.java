package com.zcm.zcy_algorithm_myStudy.LianBiao;

public class Hot02_链表中的节点每k个一组翻转 {


    /**
     * 递归函数
     * ListNode head : head表示链表的头
     * */
    public ListNode reverseKGroup (ListNode head, int k) {
        // 终止条件
        if(head ==null){
            return head;
        }

        // 找到head后面的第k个节点，如果后续节点数量不到k个，则不进行反转，直接返回head
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail !=null) {
                tail = tail.next;
            } else {
                return head;
            }
        }

        // 反转 head.....tail-1
        ListNode cur = head;
        ListNode pre = null;
        while (cur != tail) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // 递归获得  tail........end节点
        head.next = reverseKGroup(tail, k);

        // 返回值是当前递归的pre
        return pre;
    }
}
