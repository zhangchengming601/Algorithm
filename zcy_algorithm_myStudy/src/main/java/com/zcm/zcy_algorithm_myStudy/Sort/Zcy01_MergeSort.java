package com.zcm.zcy_algorithm_myStudy.Sort;


/**
 * 归并排序
 * */
public class Zcy01_MergeSort {
    public static void mergeSort(int[] arr){
        if (arr==null || arr.length<2) {
            return;
        }
        process(arr,0,arr.length-1);

    }

    /**让[left....right]上变得有序*/
    public static void process(int[] arr, int left, int right ) {
        // 如果left==right 那么说明此时这个位置上只有一个元素
        if (left==right){
            return;
        }
        int mid = (left+right)/2;
        process(arr,left,mid);
        process(arr,mid+1,right);
        merge(arr,left,right,mid);

    }
    public static void merge(int[] arr, int left, int right, int mid) {
        int[] tmp = new int[right-left+1];

        int l = left;
        int r = mid+1;
        int i = 0;

        // 当l指针和r指针不越界的时候
        while (l<=mid && r<=right) {
            if (arr[l]<arr[r]){
                tmp[i++] = arr[l];
                l++;
            } else {
                tmp[i++] = arr[r];
                r++;
            }
        }
        // 要么l指针越界，要么r指针越界
        while (l<=mid){
            tmp[i++] = arr[l];
            l++;
        }
        while (r<=right) {
            tmp[i++] = arr[r];
            r++;
        }
        // 将tmp数组重新刷回arr
        for(int j : tmp){
            arr[left++] = j;
        }
    }
}
