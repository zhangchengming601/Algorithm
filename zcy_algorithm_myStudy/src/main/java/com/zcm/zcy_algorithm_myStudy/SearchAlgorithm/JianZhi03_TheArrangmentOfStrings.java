package com.zcm.zcy_algorithm_myStudy.SearchAlgorithm;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 *  字符串的排列
 *  https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&tqId=23291&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * */
public class JianZhi03_TheArrangmentOfStrings {

    public ArrayList<String> Permutation (String str) {
        if (str=="" || str==null || str.length()==0) {
            return new ArrayList<String>();
        }

        // 将str转为字符数组
        char[] charArray = str.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        process(charArray,0,res);
        return res;
    }

    public static void process(char[] chars, int index, List<String> res){
        // 终止条件
        if (index==chars.length) {
            res.add(String.valueOf(chars));
        }

        HashSet<Character> set = new HashSet<>();
        for (int i=index; i<chars.length; i++) {
            if (set.contains(chars[i])){
                continue;
            }
            set.add(chars[i]);
            swap(chars,i,index);
            process(chars,index+1,res);
            swap(chars,i,index);
        }

    }

    public static void swap(char[] arr, int i, int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
