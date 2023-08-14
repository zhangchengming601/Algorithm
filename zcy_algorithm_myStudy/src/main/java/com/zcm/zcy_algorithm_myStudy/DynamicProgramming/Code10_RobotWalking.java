package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;


/**
 * 机器人走路
 * 假设有排成一行的N个位置，记为：1~N，N一定大于或等于2
 * 开始时机器人在其中的M位置上(M一定是1~N中的一个)
 * 如果机器人来到1的位置，那么下一步只能往右来到2的位置
 * 如果机器人来到N的位置，那么下一步只能往左来到N-1的位置
 * 如果机器人来到中间位置，那么下一步可以往左走或者往右走
 * 规定机器人开始在M位置，必须走K步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 * 给定四个参数 N、M、K、P,返回方法数。
 * */
public class Code10_RobotWalking {

    public static int begin(int n , int m , int k , int p){
        if (n<2 || k<1 || m<1 || m>n || p<1 || p>n){
            return 0;
        }
        return walk(n,m,k,p);
    }

    /**
     * int n : 表示一共有1.。。。。n个位置
     * int cur : 表示当前来到了cur这个位置
     * int rest : 表示还剩余rest步需要走
     * int p : 表示最终需要走到的位置
     *
     * 函数的意义 : 不管之前走了多少步，不管之前做了什么决策，反正当前来到了cur这个位置，还剩余rest步没有走;
     * 返回值就是当前这个情况下，有多少种方案可行
     * */
    public static int walk(int n , int cur , int rest , int p){
        // 终止条件
        if (rest==0){
            // 如果剩余步数位为0了，如果此时来到的位置就是最终的位置，则当前这种方案是可行的，否则返回0
            return cur == p ? 1 : 0;
        }
        // 如果rest>0
        // 如果 cur == 1 说明此时来到了最左侧的位置,则下一步一定是向右走一步
        if (cur == 1){
           return walk(n,cur+1,rest-1,p);
        }
        // 如果 cur == n 说明此时机器人来到了最右侧的位置，那么下一步一定是向左走一步
        if (cur==n){
            return walk(n,cur-1,rest-1,p);
        }
        // 如果机器人是在中间位置，则可以向左或者向右走
        return walk(n,cur-1,rest-1,p) + walk(n,cur+1,rest-1,p);
    }

    public static void main(String[] args) {
        System.out.println(beginWithCache(7,5,6,1));
    }

    public static int beginWithCache(int n , int m , int k , int p){
        if (n<2 || k<1 || m<1 || m>n || p<1 || p>n){
            return 0;
        }
        // int[][] bp : 其中x轴表示一共有cur一共有多少种可能，y轴表示剩余的步数一共有多少中可能
        // bp[x][y] : 表示当前在x位置，剩余y步，走到p位置的方案有多少种
        int[][] bp = new int[n+1][k+1];
        // 初始化bp， 将bp中的元素都设为-1
        for (int row=0 ; row<=n ; row++){
            for (int col=0 ; col<=k ; col++){
                bp[row][col]=-1;
            }
        }

        return walkWithCache(n,m,k,p,bp);
    }

    /**
     * int n : 表示一共有1.。。。。n个位置
     * int cur : 表示当前来到了cur这个位置
     * int rest : 表示还剩余rest步需要走
     * int p : 表示最终需要走到的位置
     *
     * 函数的意义 : 不管之前走了多少步，不管之前做了什么决策，反正当前来到了cur这个位置，还剩余rest步没有走;
     * 返回值就是当前这个情况下，有多少种方案可行
     * */
    public static int walkWithCache(int n , int cur , int rest , int p ,  int[][] bp){
        // 此时走到了cur位置，剩余rest步，如果缓存中有结果，则直接从缓存中返回结果
        if (bp[cur][rest]!=-1){
            return bp[cur][rest];
        }

        // 如果缓存中没有结果，则走下面的处理流程

        // 终止条件
        if (rest==0){
            // 如果剩余步数位为0了，如果此时来到的位置就是最终的位置，则当前这种方案是可行的，否则返回0
            // 将结果放到缓存中
            bp[cur][rest] = cur == p ? 1 : 0 ;
            return bp[cur][rest];
        }
        // 如果rest>0
        // 如果 cur == 1 说明此时来到了最左侧的位置,则下一步一定是向右走一步
        if (cur == 1){
            bp[cur][rest] = walkWithCache(n,cur+1,rest-1,p,bp);
            return bp[cur][rest];
        }
        // 如果 cur == n 说明此时机器人来到了最右侧的位置，那么下一步一定是向左走一步
        if (cur==n){
            bp[cur][rest] = walkWithCache(n,cur-1,rest-1,p,bp);
            return bp[cur][rest];
        }
        // 如果机器人是在中间位置，则可以向左或者向右走
        bp[cur][rest] = walkWithCache(n,cur-1,rest-1,p,bp) + walkWithCache(n,cur+1,rest-1,p,bp);
        return bp[cur][rest];
    }
}
