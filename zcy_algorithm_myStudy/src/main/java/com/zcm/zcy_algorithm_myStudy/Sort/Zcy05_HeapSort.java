package com.zcm.zcy_algorithm_myStudy.Sort;


/**
 * 堆排序
 * */
public class Zcy05_HeapSort {
    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }

        // 首先遍历数组使用 heapInsert 插入堆中，按照大根堆或者小根堆排序
        for (int i=0; i< arr.length; i++){
            heapInsert(arr,i);
        }

        // 然后弹出根节点,    并且heapSize --， 把堆中的最后一个元素放在根节点，做heapify
        int size = arr.length;
        swap(arr,0,--size);
        while(size>0) {
            heapify(arr,0,size);
            swap(arr,0,--size);
        }
    }

    /**
     * 堆插入
     * int i : i其实就是此时的heapSize (还未插入元素时的heapSize)
     *
     * */
    public static void heapInsert(int[] arr, int i){
        // 先拿到当前节点的父节点
        int father = (i-1)/2;
        while (arr[father]<arr[i]) {
            // 如果父节点小于当前插入的节点，则交换二者
            swap(arr,father,i);
            // 更新当前节点和父节点
            i=father;
            father = (father-1)/2;
        }
    }

    /**
     * heapify
     * int index : 当前在数组中的位置
     * int size : heapSize的大小
     * */
    public static void heapify(int[] arr,int index, int size){
        // 先拿到当前节点的左孩子节点索引
        int left = 2*index+1;
        while (left<size) {
            // 当前节点的两个子节点，的最大值的索引
            int largest = left+1<size && arr[left+1]>arr[left] ? left+1 : left;
            // 比较最大的孩子和父节点的大小
            largest = arr[largest]>arr[index] ? largest : index;  // 此时largest就是 父，左子，右子  三者中的最大值的索引
            if (largest==index){
                break;
            }
            // 如果子节点比父节点大，则交换两者的值
            swap(arr,index,largest);
            // 向下遍历
            index = largest;
            left = 2*largest+1;
        }
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
