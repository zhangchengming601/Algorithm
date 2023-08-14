package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Code03_PrintAllPermutations {

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs, 0, res);
        res.sort(null);
        return res;
    }

    public static void process(char[] chs, int i, ArrayList<String> res) {
        if (i == chs.length) {
            res.add(String.valueOf(chs));
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < chs.length; j++) {
            if (!visit[chs[j] - 'a']) {
                visit[chs[j] - 'a'] = true;
                swap(chs, i, j);
                process(chs, i + 1, res);
                swap(chs, i, j);
            }
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }


    public static void main(String[] args) {
        String test = "aaa";
        char[] chars = test.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        myProcess2(chars,0,result);
        result.stream().forEach(s -> System.out.println(s));
    }


    /**
     * char[] str : 表示字符数组,用于存放字符串中每个字符元素
     * int index : 表示进行到第几个位置
     * List<String> result : 结果集
     * */
    public static void myProcess(char[] str , int index , List<String> result){
        // 终止条件
        if (index==str.length){
            result.add(String.valueOf(str));
            return;
        }

        // 递归逻辑
        for (int i=index;i<str.length;i++){
            // 先交换两个字符的位置
            mySwap(str,index,i);
            // 递归
            myProcess(str,index+1,result);
            // 再还原str数组
            mySwap(str,index,i);
        }
    }

    public static void mySwap(char[] str , int left , int right){
        char temp = str[left];
        str[left]=str[right];
        str[right]=temp;
    }

    public static void myProcess2(char[] str , int index , List<String> result){
        // 终止条件
        if (index==str.length){
            result.add(String.valueOf(str));
            return;
        }

        // 递归逻辑
        HashSet<Character> set = new HashSet<Character>();
        for (int i=index;i<str.length;i++){
            boolean contains = set.contains(str[i]);
            if(contains){
                continue;
            }
            set.add(str[i]);
            // 先交换两个字符的位置
            mySwap(str,index,i);
            // 递归
            myProcess2(str,index+1,result);
            // 再还原str数组
            mySwap(str,index,i);
        }
    }


}