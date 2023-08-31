package com.zcm.zcy_algorithm_myStudy.Sort;


/**
 * 小和问题
 * 小和问题其实是归并排序衍生出来的题目，与归并排序的思想相似
 * 题目：在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和
 * 例子：[1,3,4,2,5] 1左边没有比1小的数，3左边比3小的数有：1；4左边比4小的数：1,3
 * 2左边比2小的数：1；5左边比5小的数：1,3,4,2
 * 因此小和为：1 + 1 + 3 + 1 + 1 + 3 + 4 + 2 = 16
 *
 *
 * */
public class Zcy02_XiaoHe {

    private static int count = 0;
    public static int process(int[] arr){
        mergeSort(arr,0,arr.length-1);
        return count;
    }

    public static void mergeSort(int[] arr, int left, int right){
        // 终止条件
        if (left==right) {
            return;
        }

        //int mid =  left + ((right- left) >> 1);
        int mid =  (left+right)/2;

        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,right,mid);
    }

    public static void merge(int[] arr,int left,int right,int mid){
        // 辅助数组
        int[] tmp = new int[right-left+1];

        int le = left;
        int re = mid+1;
        int i = 0;

        while(le<=mid && re<=right) {
            if (arr[le] < arr[re]) {
                // 如果左边的数比右边的数小，则记录小和(  (right-re+1)：右边比当前arr[le]大的数的个数)
                count+=(arr[le] * (right-re+1));
                tmp[i++] = arr[le++];
            } else {
                // 如果左边的数等于右边的数，则不产生小和，并且将右边的数添加到tmp中
                // 如果左边的数大于右边的数，不产生小和，将右边的数添加到tmp数组中
                tmp[i++] = arr[re++];
            }
        }
        while(le<=mid) {
            tmp[i++] = arr[le++];
        }
        while (re<=right) {
            tmp[i++] = arr[re++];
        }
        for (int j : tmp) {
            arr[left++] = j;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        System.out.println(process(arr));
    }
}
