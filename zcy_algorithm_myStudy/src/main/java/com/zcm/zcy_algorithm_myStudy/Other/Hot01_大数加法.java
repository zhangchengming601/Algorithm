package com.zcm.zcy_algorithm_myStudy.Other;

public class Hot01_大数加法 {
    public String solve (String s, String t) {
        // carry表示进制位
        int carry=0;
        int sLen = s.length()-1;
        int tLen = t.length()-1;
        StringBuilder res = new StringBuilder();

        // 从两个字符串的末尾开始遍历
        while(sLen>=0 && tLen>=0){
            // 拿到指针指向的两个字符串的值
            char sNum = s.charAt(sLen);
            char tNum = t.charAt(tLen);

            // 将两个值相加，并且加上上一步的进制位
            int sum = (sNum-'0')+(tNum-'0')+carry;

            // 取sum个数上的数字
            res.append(sum%10);
            // 进制位是十位数上的数字
            carry=sum/10;
            sLen--;
            tLen--;
        }
        // 当s还有剩余时
        while(sLen>=0){
            char sNum = s.charAt(sLen);
            int sum = (sNum-'0')+carry;
            res.append(sum%10);
            carry=sum/10;
            sLen--;
        }
        // 当t还有剩余时
        while(tLen>=0){
            char tNum = t.charAt(tLen);
            int sum = (tNum-'0')+carry;
            res.append(sum%10);
            carry=sum/10;
            tLen--;
        }
        // 检查carry是否为0
        while(carry!=0){
            res.append(carry);
            carry--;
        }

        // 反转字符串
        return res.reverse().toString();
    }
}
