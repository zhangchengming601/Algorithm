package com.zcm.zcy_algorithm_myStudy.Sort;

/**
 *  数组中的逆序对
 *  https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=13&tqId=23260&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * */
public class JianZhi01_ReversePairsInArrays {
    private static int count = 0 ;

    public int InversePairs (int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return count;

    }

    /**
     * 归并
     * */
    public static void mergeSort(int[] nums, int left, int right){
        if (left>=right){
            return;
        }

        // 先分
        int mid = (left+right)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);

        //再合
        merge(nums,left,right,mid);
    }

    public static void merge(int[] nums,int left, int right,int mid){
        // 辅助数组
        int[] arr = new int[right-left+1];
        int c=0;
        int le = left;
        int re = mid+1;
        while (le<=mid && re<=right){
            if (nums[le]>nums[re]) {
                // 存在逆序对
                count += (mid-le+1);
                arr[c] = nums[re];
                re++;
                c++;
            }else {
                arr[c] = nums[le];
                le++;
                c++;
            }
        }
        while (le<=mid){
            arr[c++] = nums[le++];
        }
        while (re<=right){
            arr[c++] = nums[re++];
        }
        int s = left;
        for (int i : arr) {
            nums[s++] = i;
        }

    }


}
