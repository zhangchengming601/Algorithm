package com.zcm.zcy_algorithm_myStudy.MyTest.haoweilai_0915;

import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}


public class Main03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int[] arr = new int[split.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.valueOf(split[i]);
        }

        ListNode head = process(constructList(arr));

        System.out.print(head.val);
        head = head.next;
        while(head!=null){
            System.out.print("->");
            System.out.print(head.val);
            head=head.next;
        }
    }


    public static ListNode constructList(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode cur =head;
        for(int i=1;i<arr.length;i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }


    public static ListNode process(ListNode head){
        ListNode pre = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
