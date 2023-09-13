package com.zcm.zcy_algorithm_myStudy.MyTest.weizhong_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        in.nextLine();
        String s = in.nextLine();
        String[] split = s.split(" ");
        for(int i=0;i<split.length;i++){
            arr[i] = Integer.valueOf(split[i]);
        }
        int[] res = process(arr);

        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }

    public static int[] process(int [] arr){
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();

        for(int i=arr.length-1;i>=0;i--){
            if(map.containsKey(arr[i])){
                continue;
            }
            map.put(arr[i],true);
            res.add(arr[i]);
        }
        int[] resArr = new int[res.size()];
        for(int i=0;i<res.size();i++){
            resArr[i] = res.get(res.size()-i-1);
        }
        return resArr;
    }
}
