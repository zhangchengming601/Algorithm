package com.zcm.zcy_algorithm_myStudy.MyTest.weizhong_01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main02 {

    public static int[] process(int[] arr){

        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList();
        for(int i=0;i<arr.length;i++){
            queue.add(arr[i]);
        }

        while(queue.size()!=0){
            list.add(queue.removeFirst());
            if(queue.size()!=0){
                Integer num = queue.removeFirst();
                queue.add(num);
            }
        }

        int[] res = new int[list.size()];
        for (int i =0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        in.nextLine();
        String s = in.nextLine();
        String[] split = s.split(" ");
        for(int i=0;i<num;i++){
            arr[i] = Integer.valueOf(split[i]);
        }
        int[] res = process(arr);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
