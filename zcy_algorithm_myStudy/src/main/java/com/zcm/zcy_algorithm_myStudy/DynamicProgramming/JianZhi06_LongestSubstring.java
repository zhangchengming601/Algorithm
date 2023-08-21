package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;


import java.util.HashMap;

/**
 * 题目：最长不含重复字符的子字符串
 * https://www.nowcoder.com/practice/48d2ff79b8564c40a50fa79f9d5fa9c7?tpId=13&tqId=2276769&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * */
public class JianZhi06_LongestSubstring {
    public static int processByDoublePointer(String s){
        // 1. 定义一个map，其中key是字符串中的字符 ，value是这个字符在字符串中的索引下标
        HashMap<Character, Integer> map = new HashMap<>();
        // 2. slow是慢指针
        int slow = 0;
        // 3. res是最长的子字符串的长度
        int res = 0;
        // 4. 定义一个快指针，向后遍历
        for (int fast=0; fast<s.length(); fast++) {

            if (map.containsKey(s.charAt(fast))) {
                // 7. 如果map中有该字符的记录，则更新slow指针，则分为两种情况；
                // 7.1 当前的这个重复字符，在slow指针之后
                // 7.2 当前的这个重复字符，是在slow指针之前（这是因为之前更新慢指针的时候，直接跳过了这个字符）
                slow = Math.max(slow,map.get(s.charAt(fast))+1);
            }
            // 5. 如果map集合中没记录，则将该字符和该字符的索引放入map中
            map.put(s.charAt(fast),fast);
            // 6. 更新当前的最长长度
            res = Math.max(res,fast-slow+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(processByDoublePointer(" "));
    }

}
