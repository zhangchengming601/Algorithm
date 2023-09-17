package com.zcm.zcy_algorithm_myStudy.MyTest.wubatongcheng_0916;

import java.util.Arrays;

public class Main01 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,4};
        System.out.println(calculate(2,3,arr));
    }

    public static int calculate (int m, int n, int[] scores) {
        Arrays.sort(scores);
        int len = scores.length;
        int left = scores[len-1];
        int right = scores[0];
        int res = Integer.MAX_VALUE;

        while(left>=right){
            int mid = (left+right)/2;
            int count = process(scores, mid);
            if(count >= m && count<=n){
                res = Math.min(res,count);
                right=mid+1;
            }else if(count<m){
                left = mid-1;
            }else {
                right = mid+1;
            }

        }
        return res;
    }

    public static int process(int[] scores, int threshold){
        int count = 0;
        for(int score : scores){
            if(score > threshold){
                count++;
            }
        }
        return count;
    }
}
