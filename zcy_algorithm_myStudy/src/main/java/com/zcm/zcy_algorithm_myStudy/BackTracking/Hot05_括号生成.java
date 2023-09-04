package com.zcm.zcy_algorithm_myStudy.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hot05_括号生成 {

    private ArrayList<String> res = new ArrayList();
    public ArrayList<String> generateParenthesis (int n) {
        process(n,n,"");
        return res;

    }

    /**
     * left : 左括号的剩余数量
     * right : 右括号的剩余数量
     * path : 之前已选择的括号组成的字符串
     * */
    public void process(int left,int right, String path){
        // 终止条件
        if (left==0 && right==0){
            // 如果左右括号都用完了，则将结果添加到res中
            res.add(path);
            return;
        }

        // 单层递归逻辑
        // 如果左括号还有剩余，则先使用一个左括号，进行递归
        if(left>0){
            process(left-1,right,path+"(");
        }
        // 当右括号剩余量大于左括号时，使用一个右括号，进行递归
        if (right>0 && right>left){
            process(left,right-1,path+")");
        }
    }
}
