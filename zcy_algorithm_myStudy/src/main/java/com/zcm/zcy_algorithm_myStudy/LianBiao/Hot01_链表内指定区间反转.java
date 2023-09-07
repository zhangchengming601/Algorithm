package com.zcm.zcy_algorithm_myStudy.LianBiao;


class ListNodee{
    int val;
    ListNodee next;

    public ListNodee(int val){
        this.val=val;
    }

}
public class Hot01_链表内指定区间反转 {
//    public ListNode reverseBetween (ListNodee head, int m, int n) {
//
//    }

    public ListNode reverseBetween (ListNode head, int m, int n) {
        int[] arr = new int[n-m+1];
        int index=0;

        ListNode cur= head;
        int i=1;
        while(cur!=null){
            if (i==n){
                arr[index]=cur.val;
                break;
            }
            if(i>=m){
                arr[index++]=cur.val;
            }
            cur=cur.next;
            i++;
        }

        cur=head;
        i=1;
        while(cur!=null){
            if(i==n){
                cur.val=arr[index];
                break;
            }
            if(i>=m){
                cur.val=arr[index--];
            }
            cur=cur.next;
            i++;

        }
        return head;
    }



    public ListNode reverseBetween02  (ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(-1);

        dummyNode.next=head;
        ListNode pre = dummyNode;

        // 让pre节点走到交换链表的前一个节点
        for(int i=1;i<m;i++){
            pre=pre.next;
        }

        ListNode dummyHead = pre.next;

        ListNode cur = dummyHead;
        ListNode nodePre = new ListNode(-1);
        ListNode dummyPre = nodePre;
        for(int i=0;i<m-n;i++){
            ListNode next= cur.next;
            cur.next=dummyPre;
            dummyPre=cur;
            cur=next;
        }

        pre.next=dummyPre;
        cur.next=dummyHead;
        return head;
    }
}
