package com.zcm.zcy_algorithm_myStudy.SearchAlgorithm;


/**
 * 数字在升序数组中出现的次数
 * https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=23274&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * */
public class JianZhi01_JZ53 {

    public int GetNumberOfK (int[] nums, int k) {
        return biSearch(nums,k-0.5) + biSearch(nums,k+0.5);
    }

    public static int biSearch(int[] nums , double k){
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (k > nums[mid]) {
                left = mid+1;
            } else if (k < nums[mid]){
                right = mid-1;

            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] arr={1,2,3,3,3,3,4,5};
        System.out.println(biSearch(arr,2.5));
        System.out.println(biSearch(arr,3.5));
    }
}
