package com.zcm.zcy_algorithm_myStudy.QueueAndStack;


import java.util.Stack;

/**
 * 用两个栈实现队列
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=23281&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * */
public class JianZhi01_QueueWithTwoStacks {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * push ：就是将元素压入队列中
     * */
    public void push(int node) {
        stack1.push(node);
        if (stack2.size() ==0 ){
            while (stack1.size()!=0){
                stack2.push(stack1.pop());
            }
        }
    }

    /**
     * pop：就是从队列中取出元素
     * */
    public int pop() {
        if (stack2.size()==0){
            while (stack1.size()!=0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
