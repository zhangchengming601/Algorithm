package com.zcm.zcy_algorithm_myStudy.QueueAndStack;


import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=23290&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * */
public class JianZhi02 {

    public boolean IsPopOrder (int[] pushV, int[] popV) {
        if (pushV.length==0 || popV.length==0){
            return false;
        }
        // 栈
        Stack<Integer> stack = new Stack<>();
        // index用于记录pushV数组中走到第几个元素了
        int index = 0;
        // top用于记录栈顶元素的位置（当栈为空的时候，top==-1）
        int top = -1;
        for (int i=0; i<popV.length; i++){
            int curNum = popV[i];

            // 如果栈顶元素和curNum不一样，则向栈中push新的元素，并比较和curNum是否一样
            while (stack.size()==0 || stack.get(top)!=curNum){
                if (index>=pushV.length){
                    return false;
                }
                stack.push(pushV[index]);
                top++;
                index++;
            }

            // 如果栈顶元素和curNum是一样的，则移除栈顶元素，for循环继续
            if (stack!=null && curNum== stack.get(top)) {
                stack.pop();
                top--;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.get(0));  // 1
        System.out.println(stack.get(1));  // 2
    }
}
