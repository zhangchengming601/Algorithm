package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Code06_ConvertToLetterString {


    /**
     * char[] str : 用于存放字符串中每个字符元素
     * int index : 索引
     * 返回值 : 当前路径是否可以构成一个结果，可以构成则返回1，不能构成则返回0
     * */
    public static int process(char[] str , int index){
        // 1. 终止条件
        // 1.1 如果index等于str的长度，则表明走到末尾了，说明构成了一个结果
        if (index==str.length){
            return 1;
        }
        // 1.2 如果当前str[index]=='0'（不是末尾）,则后续均无法构成一个结果（因为0无法转换）
        if (str[index]=='0'){
            return 0;
        }

        // 2.递归逻辑
        // 2.1 当当前index位置为 '1'的时候
        if (str[index]=='1'){
            // 将当前字母作为一个转换，然后接着递归
            int res=process(str,index+1);

            //将当前字母和当前的下一个字母作为整体进行转换，然后接着递归
            if(index+1<str.length){
                res+=process(str,index+2);
            }
            return res;
        }

        // 2.2 当前index位置为 '2' 的时候
        if (str[index]=='2'){
            // 将当前字母作为一个转换，然后接着递归
            int res=process(str,index+1);

            //将当前字母和当前的下一个字母（小于6）作为整体进行转换，然后接着递归
            if(index+1<str.length && str[index+1]>='0'&&str[index+1]<='6'){
                res+=process(str,index+2);
            }
            return res;
        }

        // 2.3 当前位置为 '3'-'9'的时候
        return process(str,index+1);

    }

    public static void main(String[] args) {
        String test="11111";
        char[] chars = test.toCharArray();
        System.out.println(process(chars,0));


//        String test="12345";
//        char[] chars = test.toCharArray();
//        System.out.println(Arrays.copyOfRange(chars,1,3));
    }
}
