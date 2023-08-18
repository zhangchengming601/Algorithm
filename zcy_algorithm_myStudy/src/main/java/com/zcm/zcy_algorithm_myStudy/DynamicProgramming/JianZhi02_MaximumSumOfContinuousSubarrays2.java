package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;


import java.util.Arrays;

/**
 * 题目：连续子数组的最大和
 * 牛客链接 ：https://www.nowcoder.com/practice/11662ff51a714bbd8de809a89c481e21?tpId=13&tqId=2282583&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * */
public class JianZhi02_MaximumSumOfContinuousSubarrays2 {

    public static int[] getAnswerByGreedy(int[] array){
        int maxSum = array[0];
        int subArraySum = array[0];

        int maxBeginIndex = 0;
        int maxEndIndex = 0;
        int subBeginIndex = 0;
        int subEndIndex = 0;
        for (int index=1; index<array.length; index++) {

            if (subArraySum<0) {
                // 如果subArraySum 是小于0的，则子数组从当前index开始
                subArraySum = array[index];
                // 更新subBeginIndex和subEndIndex
                subBeginIndex = index;
                subEndIndex = index;
            }else {
                subArraySum += array[index];
                // 更新更新subBeginIndex和subEndIndex
                subEndIndex = index;
            }
            if(subArraySum == maxSum && (maxEndIndex-maxBeginIndex+1) < (subEndIndex - subBeginIndex+1)){
                // 当两个子数组的长度都是最大时，则取长度最长的
                maxBeginIndex = subBeginIndex;
                maxEndIndex = subEndIndex;
            }
            if (subArraySum>maxSum) {
                // 更新maxSum
                maxSum = subArraySum;
                maxBeginIndex = subBeginIndex;
                maxEndIndex = subEndIndex;
            }
        }
        int result[] = new int[maxEndIndex-maxBeginIndex+1];
        for (int i=0; i<maxEndIndex-maxBeginIndex+1; i++){
            result[i] = array[maxBeginIndex+i];
        }
        return result;
    }


    public static void main(String[] args) {
        int[] array = {1,-2,3,10,-4,7,2,-5};
        int[] result = getAnswerByGreedy(array);
        for (int i=0; i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
