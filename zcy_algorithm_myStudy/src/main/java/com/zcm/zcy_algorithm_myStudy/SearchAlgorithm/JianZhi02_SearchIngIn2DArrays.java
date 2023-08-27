package com.zcm.zcy_algorithm_myStudy.SearchAlgorithm;


import org.w3c.dom.ls.LSOutput;

/**
 * 二维数组中的查找
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=23256&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * */
public class JianZhi02_SearchIngIn2DArrays {
    public boolean Find (int target, int[][] array) {
        if (array==null || array.length==0 || (array.length==1&&array[0].length==0) ||target<array[0][0]){
            return false;
        }
        int bot = array.length-1;
        int left = 0;
        int right = array[0].length;
        while (bot>=0 && left<right) {
            if (array[bot][left]==target) {
                return true;
            } else if (target>array[bot][left]) {
                left++;
            } else if (target<array[bot][left]) {
                bot--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int arr[][]=new int[0][];
        System.out.println(arr.length);
    }
}
