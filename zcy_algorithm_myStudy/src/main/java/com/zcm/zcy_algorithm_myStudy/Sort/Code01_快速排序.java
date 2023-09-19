package com.zcm.zcy_algorithm_myStudy.Sort;

import java.util.Arrays;

public class Code01_快速排序 {

    /**
     *
     * */
    public static int partition(int[] arr, int left , int right){
        // 取最后一个元素作为中心元素
        int basic = arr[right];

        int pointer = left;

        // 遍历数组中的所有元素，将比中心元素大的放在右边，比中心元素小的放在左边
        for(int i=left;i<right;i++){
            if (arr[i] <= basic){
                // 如果 arr[i] 小于basic  ，说明需要把arr[i] 放在basic的左边
                // 将比中心元素小的元素和指针指向的元素交换位置
                // 如果第一个元素比中心元素小，这里就是自己和自己交换位置，指针和索引都向下一位移动
                // 如果元素比中心元素大，索引向下移动，指针指向这个较大的元素，直到找到比中心元素小的元素，并交换位置，指针向下移动
                swap(arr,pointer,i);
                pointer++;
            }
        }

        // 要将pointer指向的元素替换为bacis
        swap(arr,pointer,right);
        return pointer;
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void process(int[] arr, int left, int right){
        // 终止条件
        if(left>=right){
            return;
        }

        // 递归逻辑
        if (left<right){
            int partition = partition(arr, left, right);
            // 递归左区间
            process(arr,left,partition-1);
            // 递归右区间
            process(arr,partition+1,right);
        }

    }


    public static void main(String[] args) {
        int[] arr = {19,97,9,17,1,8};
        process(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(a-> System.out.print(a + "  "));
    }
}
