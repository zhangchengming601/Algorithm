package com.zcm.zcy_algorithm_myStudy.LianBiao;

public class Test {


    /**
     * 传入的参数是个int数组，表示链表中节点的值
     * 返回值是链表的表头
     * */
    public ListNode construct(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;

        for(int i=1;i<arr.length;i++){
            cur.next=new ListNode(arr[i]);
            cur=cur.next;
        }
        cur.next=null;
        return head;
    }
}
