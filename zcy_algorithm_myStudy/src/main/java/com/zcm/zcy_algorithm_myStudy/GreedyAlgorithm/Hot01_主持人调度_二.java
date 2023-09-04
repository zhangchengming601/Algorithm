package com.zcm.zcy_algorithm_myStudy.GreedyAlgorithm;

public class Hot01_主持人调度_二 {
    public int minmumNumberOfHost (int n, int[][] startEnd) {
        int[] startTime = new int[n];
        int[] endTime = new int[n];

        for(int i=0;i<n;i++){
            startTime[i]=startEnd[i][0];
            endTime[i]=startEnd[i][1];
        }

        int res = 0;
        int endIndex=0;  // 用endIndex来记录最后的最近的一个会议结束的时间
        for (int i = 0; i<n;i++){
            if (i==0){
                res++;
                continue;
            }

            // 判断前一个会议的结束时间，是不是在现在这个会议的开始时间之前
            if (startTime[i] > endTime[endIndex]){

                continue;
            }
            endIndex++;
            res++;

        }
        return res;
    }
}
