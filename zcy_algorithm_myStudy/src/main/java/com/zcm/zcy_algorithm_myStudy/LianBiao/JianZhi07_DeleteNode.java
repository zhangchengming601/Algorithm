package com.zcm.zcy_algorithm_myStudy.LianBiao;


/**
 * 删除链表的节点
 * */
public class JianZhi07_DeleteNode {
    public ListNode deleteNode (ListNode head, int val) {
        if (head==null){
            return head;
        }
        if (head.val==val){
            return head.next;
        }
        ListNode cur = head;

        while (cur.next!=null && cur.next.val!=val) {
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return head;
    }
}
