package com.zcm.zcy_algorithm_myStudy.MyTest.mihayou_0917;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main01 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String[] arr = new String[num];
        in.nextLine();
        for(int i=0;i<num;i++){
            arr[i] = in.nextLine();
        }
        String[] res = process(arr);

        Arrays.stream(res).forEach(a -> System.out.println(a));
    }


    public static String[] process(String[] arr){
        String[] res = new String[arr.length];

        for(int i=0;i<arr.length;i++){
            String curS = arr[i];
            if(curS.equals("")){
                res[i] = "No";
                continue;
            }

            // 先对这个字符串进行音节拆分
            String[] split = chaiFen(curS);
            // 在判断当前名字是不是回文
            res[i] = isHuiWen(split) ? "Yes" : "No";

        }
        return res;
    }


    /**判断是否是回文*/
    public static boolean isHuiWen(String[] arr){
        int left =0;
        int right = arr.length-1;
        while(left<=right){
            if(!arr[left].equals(arr[right])){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }



    /**对字符串按照音节拆分*/
    public static String[] chaiFen(String s){
        ArrayList<String> list = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            char curChar = s.charAt(i);
            if((curChar == 'a' || curChar == 'e' ||curChar == 'i' ||curChar == 'o' ||curChar == 'u') && ((i+1)<s.length()) && (s.charAt(i+1) == 'a'|| s.charAt(i+1) == 'e' ||s.charAt(i+1) == 'i' || s.charAt(i+1) == 'o'|| s.charAt(i+1) == 'u')){
                list.add(String.valueOf(curChar) + String.valueOf(s.charAt(i+1)));
                i++;
                continue;
            }
            if (curChar == 'a' || curChar == 'e' ||curChar == 'i' ||curChar == 'o' ||curChar == 'u'){
                list.add(String.valueOf(curChar) + String.valueOf(s.charAt(i+1)));
                continue;
            }

            char nextChar = '\0';
            if(i+1<s.length()){
                nextChar = s.charAt(i+1);
            }
            if(nextChar == 'a' || nextChar == 'e' ||nextChar == 'i' ||nextChar == 'o' ||nextChar == 'u'){
                list.add(String.valueOf(curChar)+String.valueOf(nextChar));
                i++;
                continue;
            }
            list.add(String.valueOf(curChar));
        }
        String[] res = new String[list.size()];
        for(int i =0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
