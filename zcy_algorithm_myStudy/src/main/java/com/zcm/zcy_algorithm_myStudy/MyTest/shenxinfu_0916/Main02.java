package com.zcm.zcy_algorithm_myStudy.MyTest.shenxinfu_0916;

import java.util.Scanner;

public class Main02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String p = in.nextLine();
        int res = process(s, p);
        System.out.println(1);
    }

    public static int process(String s , String p ){
        char[] pArray = p.toCharArray();
        char[] sArray = s.toCharArray();

        int index = 0; // s数组的索引下标
        for(int i=0;i <p.length();i++){
            if(pArray[i]==sArray[index]){
                index++;
                continue;
            }
            if(pArray[i]!=sArray[i] && pArray[i]=='.'){
                index++;
                continue;
            }
            if(pArray[i]=='*' && i==p.length()-1){
                return 1;
            }
            if(pArray[i]=='*' && i<p.length()-1){
                char c = pArray[i + 1];
                while(sArray[index]==c){
                    index++;
                    break;
                }
                continue;
            }
            if(pArray[i]=='*' && i<p.length()-1){
                char c = pArray[i + 1];
                while(sArray[index]==c){
                    index++;
                    break;
                }
                continue;
            }
            System.out.println();
        }

        return 0;
    }
}
