package com.zcm.zcy_algorithm_myStudy.MyTest.shenxinfu_0916;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Main01 {


    public static LinkedList<Character> path = new LinkedList<>();
    public static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(process(in.nextLine()));
    }

    public static int process(String s){
        char[] array = s.toCharArray();

        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<array.length;i++){
            set.add(array[i]);
        }
        Character[] setArray = set.toArray(new Character[set.size()]);
        Arrays.sort(setArray);
        int res = 0;

        for(int i =1;i<=setArray.length;i++){
            count =0;
            handle(setArray,i,0);
            res+=count;
        }
        return res;
    }



    /**
     * 递归函数
     *
     *  array : 表示数组
     *  k : 表示一个组合中字符的个数
     *  index，表示此时来到了array的第index个字符
     * */
    public static void handle(Character[] array, int k , int index){
        // 终止条件
        if(path.size() == k){
            count++;
//            System.out.println(path.toString());
            return;
        }
        if(index>=array.length){
            return;
        }

        //递归逻辑
        for(int i=index;i<array.length;i++){
            path.add(array[i]);

            // 递归
            handle(array,k,i+1);

            // 回溯
            path.removeLast();
            while(i<array.length-1 && array[i]==array[i+1]){
                i++;
            }
        }

    }
}
