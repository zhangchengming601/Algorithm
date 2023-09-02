package com.zcm.zcy_algorithm_myStudy.examination.meituan;

import java.util.Scanner;

public class Test02 {
    public static String process(String[] arr){
        if (arr.length==0||arr==null){
            return "NO";
        }

        int len = arr.length;
        String s = "meituan";
        char[] chars = s.toCharArray();
        int index =0;
        int mStart = 0;
        for (int i=0;i<len;i++){
            String curS = arr[i];
            for (int j=0;j<curS.length();j++){
                if (curS.charAt(j)==chars[index]){
                    if (index==0){
                        mStart=i;
                    }
                    index++;
                    if (index==chars.length-1){
                        return "Yes";
                    }
                    break;
                }
                if (j==curS.length()-1&&index!=0){
                    // 回退到第一个发现m字符的位置
                    i=mStart;
                    index=0;
                }
            }
        }
        return "No";
    }

    public static void main(String[] args) {
        //String[] arr = new String[]{"abc","def","ghi"};
        //String[] arr = new String[]{"dddm","ffeuu","rrm","tte","i","t","u","a","n"};

        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        String[] arr= new String[row];
        in.nextLine();
        for(int i=0;i<row;i++){
            arr[i]=in.nextLine();
        }

        System.out.println(process(arr));
    }
}
