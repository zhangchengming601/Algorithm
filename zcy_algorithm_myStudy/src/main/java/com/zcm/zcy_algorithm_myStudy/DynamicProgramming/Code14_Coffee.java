package com.zcm.zcy_algorithm_myStudy.DynamicProgramming;


/**
 * 咖啡机排队问题
 *
 * 题目
 * 给定一个数组，代表每个人喝完咖啡的时间
 * 只有一台咖啡机，一次只能洗一个杯子，时间耗费a，洗完才能洗下一杯
 * 每个咖啡杯也可以自己挥发干净，时间耗费b，咖啡杯可以并行挥发
 * 返回让所有咖啡杯变干净的最早完成时间
 * 三个参数: int[] arr、int a、 int b
 *
 * */
public class Code14_Coffee {


    /**
     * int[] drinks : drinks 表示每个人喝完咖啡的时间   固定参数
     * int index : 表示现在来到了第index个杯子
     * int a  : 咖啡机洗一个咖啡杯的时间 固定变量
     * int b : 咖啡杯自己挥发干净的时间 固定变量
     * int washLine : 表示咖啡机何时可以使用
     *
     * 整个递归函数的作用就是 ：
     * 现在来到了第index个杯子处，前面0...index-1个杯子已经做了处理了
     * 咖啡机可用的时间是washLine
     * 返回处理index及其之后杯子需要的总最小时间
     *
     * */
    public static int process(int[] drinks , int index , int a , int b , int washLine){
        // 终止条件
        if (index == drinks.length-1){
            // 如果现在来到了最后一个杯子处，则有两种选择  1. 交给咖啡机去洗； 2. 让杯子自己挥发干净
            // 咖啡机洗的话，喝完这杯咖啡的时间点 和 咖啡机可用的时间点 取最大值（因为假如咖啡喝完了，但是此时咖啡机正在工作，那么此时就不能立刻让咖啡机去洗杯子），再加上洗杯子的时间
            // 自动挥发，喝完这杯咖啡的时间点 再 加上挥发的时间
            int machineTime = Math.max(drinks[index],washLine)+a;  // 交给咖啡机洗 总的时间
            int selfTime = drinks[index] +b;   // 咖啡杯自己会发干净的总时间
            // 返回 这两个选择用时最少的时间
            return Math.min(machineTime,selfTime);
        }

        // 如果没有进入上面的if条件，那就说明此时剩余的不止一杯咖啡
        // 此时的处理方式，同样是两种可能，  1. 交给咖啡机去洗 ； 2. 让杯子自己挥发干净

        // 1. 交给咖啡机去洗
        // 1.1 洗完这杯咖啡的时间
        int washTime = Math.max(drinks[index],washLine)+a;
        // 1.2 这杯咖啡之后（index+1......）需要处理的时间
        // 1.2 调用递归函数，计算index+1及其往后所有杯子处理干净的时间，咖啡机可用的时间是index杯子洗完的时间（也就是washTime）
        int next1 = process(drinks, index+1, a, b, washTime);
        // 1.3 所有杯子洗完的时间；取washTime和next1的最大值，因为要等所有杯子处理完成（包括index杯子和index之后的杯子）
        // 1.3 假如洗完index这个杯子需要1000分钟，处理完index+1及其之后的杯子需要300分钟，那么洗完所有杯子的时间就是1000分钟
        // 1.3 假如洗完index这个杯子需要200分钟，处理完index+1及其之后的杯子需要500分钟，那么洗完所有杯子的时间就是500分钟
        int p1 = Math.max(washTime,next1);

        // 2. 让杯子自己挥发干净
        // 2.1 杯子自己挥发的时间
        int selfTime = drinks[index] + b;
        // 2.2 这杯咖啡之后（index+1......）需要处理的时间
        // 2.2 调用递归函数，计算index+1及其往后所有杯子处理干净的时间，因为这里没有使用咖啡机处理，所有咖啡机可用的时间还是washLine
        int next2 = process(drinks, index+1, a, b, washLine);
        // 2.3 同理1.3
        int p2 = Math.max(selfTime,next2);

        // 返回两种方案的最小值
        return Math.min(p1,p2);
    }

    public static int getAnswer1(int[] drinks, int a , int b){
        return process(drinks,0,a,b,0);
    }


    /**
     *  int[] drinks : drinks 表示每个人喝完咖啡的时间   固定参数
     *  int a  : 咖啡机洗一个咖啡杯的时间 固定变量
     *  int b : 咖啡杯自己挥发干净的时间 固定变量
     *
     */
    public static int processByDP(int[] drinks, int a, int b ){
        int N = drinks.length;

        if (a>b){
            // 如果洗杯子的时间大于等于杯子自己挥发干净的时间
            // 那么就没必要洗，也没必要改动态规划
            // 最后一杯咖啡挥发的时间就是所有咖啡杯变干净的最早完成时间
            return drinks[N-1] + b;
        }

        // a<b 才有必要改动态规划
        // limit 全部交给咖啡机洗，总时间
        int limit = 0;
        for (int i=0; i<N; i++){
            limit = Math.max(drinks[i],limit) + a;
        }

        int[][] dp = new int[N][limit+1];

        // 给dp的最后一行（N-1）赋值
        // 变量i表示咖啡机何时可用的时间
        for(int i=0; i<limit+1; i++){
            int machineTime = Math.max(drinks[N-1],i)+a;  // 交给咖啡机洗 总的时间
            int selfTime = drinks[N-1] +b;   // 咖啡杯自己会发干净的总时间
            dp[N-1][i] = Math.min(machineTime,selfTime);
        }

        // 给dp的 N-2 ...0行赋值
        for (int index=N-2; index>=0; index--){
            for (int col=0;col<limit+1;col++){
                // 1. 交给咖啡机去洗
                // 1.1 注意： 此时washTime是可能超过limit+1的 ,所以需要进行处理
                int p1 = Integer.MAX_VALUE;
                int washTime = Math.max(drinks[index],col)+a;
                if (washTime < limit+1){
                    p1 = Math.max(washTime,dp[index+1][washTime]);
                }

                // 2. 让杯子自己挥发干净
                int selfTime = drinks[index] + b;
                int next2 = dp[index+1][col];
                int p2 = Math.max(selfTime,next2);

                dp[index][col] = Math.min(p1,p2);
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        int[] arr = {1,1,5,5,7,10,12,12,12,12,12,12,15};
        int a = 3;
        int b =10;
        System.out.println("暴力递归="+getAnswer1(arr,a,b));
        System.out.println("动态规划="+processByDP(arr,a,b));
    }


}
