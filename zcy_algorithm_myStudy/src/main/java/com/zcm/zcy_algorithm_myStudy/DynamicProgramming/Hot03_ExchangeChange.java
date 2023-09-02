package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;


/**
 * 兑换零钱
 * https://www.nowcoder.com/practice/3911a20b3f8743058214ceaa099eeb45?tpId=295&tqId=988994&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 * */
public class Hot03_ExchangeChange {
    public int minMoney (int[] arr, int aim) {
        if (aim == 0){
            return 0;
        }
        if (arr.length<=0 || aim<=0){
            return -1;
        }
        return minMoney2(arr,aim,0);
    }




    public int minMoney2(int[] arr , int rest ,int index){
        // 终止条件
        if (index <= arr.length && rest==0){
            return 0;
        }
        if (index == arr.length && rest!=0){
            return -1;
        }

        int min = -1;
        // 递归逻辑
        for (int i =1; i*arr[index]<=rest;i++) {
            // 拿 i 张 arr[index] 钱， 剩下的递归
            int num = minMoney2(arr, rest - i * arr[index], index + 1);
            if (num>=0){
                min = min==-1 ? num+i : (min>(num+i) ? (num+i) : min);
            }
        }
        return min;
    }
}
