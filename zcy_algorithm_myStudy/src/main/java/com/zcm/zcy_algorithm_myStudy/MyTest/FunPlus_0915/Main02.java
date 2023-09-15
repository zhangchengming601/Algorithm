package com.zcm.zcy_algorithm_myStudy.MyTest.FunPlus_0915;


/**
 * 链表内指定区间反转
 *
 * */
public class Main02 {

    public ListNode reverseBetween (ListNode head, int m, int n) {
        ListNode pre = new ListNode(-1);
        pre.next=head;

        ListNode cur = head;

        for(int i=1;i<m;i++){
            ListNode next = cur.next;
            pre = cur;
            cur = next;
        }
        // 此时pre指向m节点的前一个节点
        // 此时cur指向第m个节点

        ListNode dummyCur = cur;
        ListNode next = dummyCur.next;
        // 我现在需要找到第n个节点
        for(int i=m;i<n;i++){
            dummyCur = next;
            next = dummyCur.next;
        }

        //反转指定链表
        pre.next = process(cur,dummyCur);
        cur.next = next;

        return head;



    }
    public ListNode process(ListNode start , ListNode end){
        ListNode pre = new ListNode(-1);
        pre.next = null;

        ListNode cur = start;

        while(cur!=end){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur .next =pre;
        return cur;
    }

}
