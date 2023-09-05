package com.zcm.zcy_algorithm_myStudy.HashTable;

import java.util.ArrayList;
import java.util.Arrays;

public class Hot05_三数之和 {
    public ArrayList<ArrayList<Integer>> threeSum (int[] num) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num.length<3){
            return res;
        }

        // 先对数组从小到大进行排序
        Arrays.sort(num);

        // 我们要找出 a+b+c=0
        // 此处i所指向的就是a，left指向的就是b，right指向的就是c
        for(int i=0;i<num.length-2;i++){
            // 如果数组是类似于 [.....6,6,6,6,8,9,.....],则需要对重复的6进行去重
            if (i>0 && num[i]==num[i-1]){
                continue;
            }
            int left = i+1;
            int right = num.length-1;

            // while循环中移动left指针和right指针，搜索合适的元素
            while (left<right){

                if (num[i]+num[left]+num[right]==0){
                    // 如果找到满足条件的a+b+c=0 则添加到res集合中
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[left]);
                    list.add(num[right]);
                    res.add(list);

                    // 然后移动左右指针
                    left++;
                    right--;
                    // 对右指针重读的值进行去重，对左指针重复的值进行去重
                    while (left<right && num[right]==num[right+1]){
                        right--;
                    }
                    while (left<right && num[left]==num[left-1]){
                        left++;
                    }
                } else if(num[i]+num[left]+num[right]<0){
                    // 如果a+b+c<0 说明左指针太小了，移动左指针
                    left++;
                }else if (num[i]+num[left]+num[right]>0){
                    // 如果a+b+c>0 ,说明右指针太大了，移动右指针
                    right--;
                }
            }
        }
        return res;

    }
}
