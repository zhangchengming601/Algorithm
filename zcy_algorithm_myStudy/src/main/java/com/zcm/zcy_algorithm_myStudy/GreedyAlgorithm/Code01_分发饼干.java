package com.zcm.zcy_algorithm_myStudy.GreedyAlgorithm;

import java.util.Arrays;

public class Code01_分发饼干 {

    /**
     * g : 胃口值
     * s ： 饼干大小
     * */
    public int findContentChildren(int[] g, int[] s) {
        int gIndex = g.length-1;
        int sIndex = s.length-1;

        Arrays.sort(g);
        Arrays.sort(s);

        int res =0;

        while (gIndex>=0 && sIndex>=0){
            if (s[sIndex]>=g[gIndex]){
                res++;
                gIndex--;
                sIndex--;
                continue;
            }
            gIndex--;
        }
        return res;

    }
}
