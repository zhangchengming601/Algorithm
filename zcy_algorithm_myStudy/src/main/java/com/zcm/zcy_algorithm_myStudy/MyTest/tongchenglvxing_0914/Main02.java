package com.zcm.zcy_algorithm_myStudy.MyTest.tongchenglvxing_0914;

import java.util.Arrays;
import java.util.Comparator;

public class Main02 {
    public int maxEnvelopes (int[][] envelopes) {
        if(envelopes.length == 0){
            return 0;
        }

        int len = envelopes.length;

        Arrays.sort(envelopes,(o1,o2)->{
            if(o1[0] != o2[0]){
                return o1[0] - o2[0];
            }else {
                return o1[1] - o2[1];
            }
        });

        int [] dp = new int[len];
        Arrays.fill(dp,1);
        int res = 1;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(envelopes[j][1] < envelopes[i][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }

        return res;
    }
}
