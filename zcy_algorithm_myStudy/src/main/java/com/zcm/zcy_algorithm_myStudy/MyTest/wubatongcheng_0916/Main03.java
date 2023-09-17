package com.zcm.zcy_algorithm_myStudy.MyTest.wubatongcheng_0916;

import java.util.HashSet;
import java.util.List;

public class Main03 {

    public static int res =0;

    public int subsequence (String source, String pattern) {
        HashSet<Character> set = new HashSet<>();
        for(int i =0; i<pattern.length();i++){
            set.add(pattern.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<source.length();i++){
            if(set.contains(source.charAt(i))){
                sb.append(source.charAt(i));
            }
        }
        String s = sb.toString();
        char[] array = s.toCharArray();

        myProcess(array,0,"",pattern);

        return res;

    }

    public static void myProcess(char[] str,
                                 int index ,
                                 String path,
                                 String pattern
    ){
        // 终止条件
        if (index==str.length || path.length()==pattern.length()){
            if(path.equals(pattern)){
                res++;
            }
            return;
        }

        // 递归逻辑

        String yes = path+str[index]; // 表示选择该元素
        if(yes.length()<=pattern.length()){
            myProcess(str,index+1,yes,pattern);
        }

        String no = path;  // 表示不选择该元素
        if(no.length()<=pattern.length()){
            myProcess(str,index+1,no,pattern);
        }
    }
}
