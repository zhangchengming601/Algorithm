package com.zcm.zcy_algorithm_myStudy.MyTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class YiTuKeJi_0907 {
    public static String process2(String[] arr){
        HashMap<Character, Integer> map = new HashMap<>();
        int maxlen = 0;
        for(int i=0;i<arr.length;i++){
            maxlen=Math.max(maxlen,arr[i].length());
        }
        char[] tmp = new char[maxlen+1];

        for(int i=0;i<arr.length;i++){
            String cur = arr[i];

            for(int j=0;j<cur.length();j++){
                if(map.containsKey(cur.charAt(j))){
                    Integer num = map.get(cur.charAt(j))+1;
                    map.put(cur.charAt(j),num);
                    if(tmp[num]!='\0'){
                        tmp[num]= tmp[num]-cur.charAt(j)<0 ? tmp[num] : cur.charAt(j);
                        tmp[num-1]= tmp[num-1]==cur.charAt(j)? '\0' : tmp[num-1];
                        continue;
                    }
                    tmp[num]=cur.charAt(j);
                    tmp[num-1]= tmp[num-1]==cur.charAt(j)? '\0' : tmp[num-1];
                }else{
                    map.put(cur.charAt(j),1);
                    if(tmp[1]!='\0'){
                        tmp[1]= tmp[1]-cur.charAt(j)<0 ? tmp[1] : cur.charAt(j);
                        continue;
                    }
                    tmp[1] = cur.charAt(j);
                }
            }
        }

        int first = -1;
        int second =-1;
        for(int index=maxlen-1;index>=0;index--){
            if(first==-1 && tmp[index]!=' '){
                first = index;
                continue;
            }
            if(second==-1 && tmp[index]!='\0'){
                second=index;
                return tmp[index]+ "-" + index;

            }
        }
        return "ERROR";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        String s1 = stringBuilder.toString();
        String[] split = s1.split(",");
        for(int i=0;i<split.length;i++){
            StringBuilder sb = new StringBuilder(split[i]);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length()-1);
            split[i]=sb.toString();
        }
        String res = process2(split);


        System.out.println(res);
    }


    public static int process3(int[][] arr,int row,int col){
        int[] dp=new int[col];
        dp[0]=1;

        for(int i=1;i<col;i++){
            int mindel=0;
            for(int j=0;j<i;j++){
                // 比较j列和i列是否递增
                boolean flag = true;
                for(int k=0;k<row;k++){
                    if (arr[k][j]>arr[k][i]){
                        flag=false;
                        break;
                    }
                }

                if(flag){
                    // 如果j都比i行小，那么是递增的，说明不需要删行
                    mindel=Math.max(mindel,dp[j]+1);
                }else {
                    // 如果j有比i大的，那么不是递增的，i列此时不能要
                    mindel=Math.max(mindel,dp[j]);
                }
            }
            dp[i]=mindel;
        }
        return col-dp[col-1];
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int row = in.nextInt();
//        int col = in.nextInt();
//        int[][] arr = new int[row][col];
//        in.nextLine();
//        for(int i=0;i<col;i++){
//            String s = in.nextLine();
//            String[] split = s.split(" ");
//            for(int j=0;j<col;j++){
//                arr[i][j]=Integer.valueOf(split[j]);
//            }
//        }
//        int res = process3(arr, row, col);
//        System.out.println(res);
//    }
}
