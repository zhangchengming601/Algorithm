package com.zcm.zcy_algorithm_myStudy.MyTest.mihayou_0917;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        String[] split = num.split(" ");
        int n = Integer.valueOf(split[0]);
        int m = Integer.valueOf(split[1]);
        int[][] arr = new int[n][3];

        for(int i=0;i<n;i++){
            String s = in.nextLine();
            String[] sp = s.split(" ");
            arr[i][0] = Integer.valueOf(sp[0]);
            arr[i][1] = Integer.valueOf(sp[1]);
            arr[i][2] = Integer.valueOf(sp[2]);
        }

        System.out.println(process(n,m,arr));

    }

    public static int process(int n , int m , int[][] arr){

        int res = 0;
        int jiShu = 0;  //卡位上奇数的位置个数
        int ouShu = 0; // 卡位上偶数的位置个数

        for(int i=1;i<=n;i++){
            if(i%2 == 0){
                ouShu++;
            }else {
                jiShu++;
            }
        }

        int kaPaiJiShu = 0;  //卡牌是奇数的个数
        int kaPaiOuShu = 0; // 卡牌是偶数的个数
        for(int i=0;i<n;i++){
            if(arr[i][0]==1){
                kaPaiJiShu++;
            }else {
                kaPaiOuShu++;
            }
        }

        // 如果奇数卡牌个数大于奇数卡位位置个数
        if (kaPaiJiShu >jiShu ){
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
                return (o2[1]+o2[2]) - (o1[2]+o1[2]);
            });
            for(int i=0;i<n;i++){
                if(arr[i][0] ==1){
                    queue.offer(arr[i]);
                }
            }
            for(int i=1;i<=jiShu;i++){
                int[] poll = queue.poll();
                res+=poll[1]+poll[2];
            }
            for(int i=jiShu+1;i<=kaPaiJiShu;i++){
                int[] poll = queue.poll();
                res+=poll[1];
            }
            for(int i=0;i<n;i++){
                if(arr[i][0] == 2){
                    res += arr[i][1] +arr[i][2];
                }
            }

            return res;
        }

        // 如果奇数卡牌个数大于奇数卡位位置个数
        if (kaPaiOuShu>ouShu){
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
                return (o2[1]+o2[2]) - (o1[2]+o1[2]);
            });
            for(int i=0;i<n;i++){
                if(arr[i][0] ==2){
                    queue.offer(arr[i]);
                }
            }
            for(int i=1;i<=ouShu;i++){
                int[] poll = queue.poll();
                res+=poll[1]+poll[2];
            }
            for(int i=ouShu+1;i<=kaPaiOuShu;i++){
                int[] poll = queue.poll();
                res+=poll[1];
            }
            for(int i=0;i<n;i++){
                if(arr[i][0] == 1){
                    res += arr[i][1] +arr[i][2];
                }
            }
            return res;
        }

        return res;
    }

}
