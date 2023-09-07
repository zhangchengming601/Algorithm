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

    /**
     * 递归函数--拆分数组
     * 让[left....right]上变得有序*/
    public static void process(int[] arr, int left, int right ) {
        // 如果left==right 那么说明此时这个位置上只有一个元素
        if (left==right){
            return;
        }
        // 求当前arr[left....right]区间上的中间值
        int mid = (left+right)/2;
        // 拆分arr[left...mid] ,继续递归
        process(arr,left,mid);
        // 拆分arr[mid+1....right] 继续拆分
        process(arr,mid+1,right);
        // 此时arr[left...mid] 和 arr[mid+1....right] 已经分别有序，此时我们要合并arr[left...mid] 和 arr[mid+1....right]
        merge(arr,left,right,mid);

    }

    /**合并arr[left...mid] 和 arr[mid+1....right]  ，使得arr[left....right]变得有序*/
    public static void merge(int[] arr, int left, int right, int mid) {
        // 新建一个辅助数组
        int[] tmp = new int[right-left+1];

        // l和r指向左右数组的此时元素的位置，i用于指向辅助数组tmp中此时元素的位置
        int l = left;
        int r = mid+1;
        int i = 0;

        // 当l指针和r指针不越界的时候
        while (l<=mid && r<=right) {
            if (arr[l]<arr[r]){
                // 如果左指针小于右指针，则将左指针元素赋值给tmp[i]，然后移动指针
                tmp[i++] = arr[l];
                l++;
            } else {
                // 如果左指针大于右指针，则将右指针赋值给tmp[i]，右指针向后移动，左指针不动
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
