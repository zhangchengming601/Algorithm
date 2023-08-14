package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Code02_PrintAllSubsquences {

    public static char[] printAllSubsquence(String str) {
        return str.toCharArray();
       // process(chs, 0);
    }

    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        process(chs, i + 1);
        char tmp = chs[i];
        chs[i] = 0;
        process(chs, i + 1);
        chs[i] = tmp;
    }

    public static void function(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0, new ArrayList<Character>());
    }

    public static void process(char[] chs, int i, List<Character> res) {
        if(i == chs.length) {
            printList(res);
        }
        List<Character> resKeep = copyList(res);
        resKeep.add(chs[i]);
        process(chs, i+1, resKeep);
        List<Character> resNoInclude = copyList(res);
        process(chs, i+1, resNoInclude);
    }

    public static void printList(List<Character> res) {
        // ...;
    }

    public static List<Character> copyList(List<Character> list){
        return null;
    }

    public static void main(String[] args) {
        String test = "abc";
        char[] chars = printAllSubsquence(test);
        ArrayList<String> result = new ArrayList<>();
        myProcess(chars,0,result,"");

        result.stream().forEach(s -> System.out.println(s));
    }


    /**
     * char[] str : 固定不变的char数组，存放字符串中每个字符元素
     * int index : 表示在数组中走到第几个元素了，也就是树中的第几层
     * List<String> result : 当每个分支走到终点的时候，将子序列添加到result中
     * String path : path表示该路径上的元素
     * */
    public static void myProcess(char[] str, int index , List<String> result , String path){
        // 终止条件
        if (index==str.length){
            // 如果index等于char数组中长度，则表示已经到最终了
            // 将该路径上的path添加到result中
            result.add(path);
            return;
        }

        // 递归逻辑

        String yes = path+str[index]; // 表示选择该元素
        myProcess(str,index+1,result,yes);

        String no = path;  // 表示不选择该元素
        myProcess(str,index+1,result,no);
    }

}
