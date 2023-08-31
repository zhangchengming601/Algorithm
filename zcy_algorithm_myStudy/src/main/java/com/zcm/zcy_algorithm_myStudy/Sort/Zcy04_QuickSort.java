package com.zcm.zcy_algorithm_myStudy.Sort;


/**
 * 快速排序
 * */
public class Zcy04_QuickSort {

    /**
     * 快排入口
     * */
    public static void quickSort(int[] array) {
        if (array.length<2){
            return;
        }

    }

    /**
     * 递归过程
     * */
    public static void process(int[] array, int left, int right){
        // 终止条件
        if (left>=right) {
            // 如果left >= right 说明此时就剩一个元素了，则不需要再排序了，直接返回
            return;
        }

        // 交换数组中最后一个元素和数组中随机位置的一个值
        swap(array,right,left+(int)Math.random()*(right-left+1));
        // 排序---以此时的array[right]为基准，进行规则排序
        int[] partition = partition(array, left, right);

        // 递归
        process(array,left,partition[0]);
        process(array,partition[1],right);


    }

    public static int[] partition(int[] array, int left, int right) {
        int less = left-1;
        int more = right;
        while (left<more) {
            if (array[left] < array[right]) {
                swap(array,left++,++less);
            }
            if (array[left] == array[right]) {
                left++;
            }
            if (array[left] > array[right]) {
                swap(array,left++,--more);
            }
        }
        swap(array,more,right);
        return new int[]{less,more+1};
    }


    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
