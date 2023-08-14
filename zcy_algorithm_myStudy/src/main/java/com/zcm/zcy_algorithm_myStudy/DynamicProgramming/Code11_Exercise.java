package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;


/**
 * 题目：给定一个数组，例如 arr=[5,10,50,100] ,其中的元素代表不同面值的钱（50就代表50块钱），
 * 现在设定一个目标aim，假如目标是aim=1000 , 然后我们需要从数组arr中拿钱，同一个面值的前可以拿多张，
 * 请问有多少种组合的方式；例如 10张100的算一种组合；5张100的+10张50的算一种组合
 * */
public class Code11_Exercise {

    public static int getAnswer(int[] arr , int aim){
        if (arr ==null || arr.length ==0 || aim<0){
            return 0;
        }

        return process(arr,0,aim);
    }


    /**
     * int[] arr : 数组中表示不同面值的货币
     * int index : index表示之前的[0..index-1] 已经做了决定了，现在来到了第index个钱的位置
     * int rest : rest表示目前距离我的目的还需要多少钱
     *
     * 返回值 : 不管之前做了什么选择，这里只返回当前情况（rest）下，可供选择的方案数
     * */
    public static int process(int[] arr , int index , int rest){
        // 终止条件
        if (index == arr.length){
            return rest == 0 ? 1 : 0;
        }

        int res = 0;
        // 递归逻辑
        for (int zhang=0 ; zhang * arr[index] <= rest ; zhang++){
            res += process(arr,index+1,rest-(zhang * arr[index]));
        }
        return res;
    }


    public static void main(String[] args) {
        int arr[] = new int[]{5,10,50,100};

        System.out.println(getAnswer(arr,1000));
        System.out.println(getAnswerByDP1(arr,1000));
    }

    public static int getAnswerByDP1(int[] arr , int aim){
        if (arr ==null || arr.length ==0 || aim<0){
            return 0;
        }

        int N = arr.length;

        int[][] dp = new int[N+1][aim+1];
        dp[N][0] = 1;

        for(int row=N-1 ; row>=0 ; row--){
            for (int col=0 ; col<=aim ; col++){
                int res =0;
                for (int zhang=0 ; zhang*arr[row]<=col;zhang++){
                    res +=dp[row+1][col-(zhang*arr[row])];
                }

                dp[row][col] = res;
            }
        }
        return dp[0][aim];
    }
    public static int getAnswerByDP2(int[] arr , int aim){
        if (arr ==null || arr.length ==0 || aim<0){
            return 0;
        }

        int N = arr.length;

        int[][] dp = new int[N+1][aim+1];
        dp[N][0] = 1;

        for(int row=N-1 ; row>=0 ; row--){
            for (int col=0 ; col<=aim ; col++){
                dp[row][col] = dp[row+1][col];
                if (col - arr[row] >= 0){
                    dp[row][col] += dp[row][col - arr[row]];
                }
            }
        }
        return dp[0][aim];
    }

}
