package com.zcm.zcy_algorithm_myStudy.Sort;


/**
 * 荷兰国旗问题
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放 在数组的中，
 * 大于num的数放在数组的右边。要求额外空间复杂度O(1)，时间复杂度 O(N)
 *
 * */
public class Zcy03_HeLanGuoQi {

    public static int[] process(int[] nums, int target){

        int left = -1;
        int right = nums.length;

        int i = 0;
        while(i<right){
            if (nums[i]<target) {
                // 如果nums[i]小于target，那么将小于区的右一个数和当前数做交换，然后小于区右移一位
                swap(nums,++left,i++);
            }
            if (nums[i] == target) {
                // 如果nums[i] 等于target，那么只用将i后移
                i++;
            }
            if (nums[i] > target) {
                // 如果nums[i]小于target，那么将当前元素和大于区的左一个元素交换，并且大于区左移一位
                swap(nums,i,--right);
            }
        }
        return nums;
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
