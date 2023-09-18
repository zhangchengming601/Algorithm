package com.zcm.zcy_algorithm_myStudy.DoublePoint;

public class Code01_长度最小的子数组 {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int rihjt = -1;
        int curSum = 0;
        int res = Integer.MAX_VALUE;

        for(;left<nums.length && rihjt<nums.length;left++){

            // 如果区间内元素之和小于target ，则移动right指针
            while(curSum<target && rihjt<nums.length-1){
                rihjt++;
                curSum += nums[rihjt];
            }

            // 如果区间内元素之和等于target，则更新res，并左右指针均向后移动一个，并且更新curSum的值
            if(curSum==target){
                res = Math.min(res,rihjt-left+1);
                if(rihjt >=nums.length-1){
                    break;
                }
                rihjt++;
                curSum += nums[rihjt];
                curSum -= nums[left];
                continue;
            }

            // 如果区间内的元素之和大于target，则更新res，并且移动左指针
            if(curSum>target){
                res = Math.min(res,rihjt-left+1);
                curSum -= nums[left];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,arr));
    }
}
