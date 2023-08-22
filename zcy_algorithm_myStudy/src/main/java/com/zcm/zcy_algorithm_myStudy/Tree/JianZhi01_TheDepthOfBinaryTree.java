package com.zcm.zcy_algorithm_myStudy.Tree;


/**
 * 二叉树的深度
 * https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?tpId=13&tqId=23294&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * */
public class JianZhi01_TheDepthOfBinaryTree {


    /**
     * 递归方法
     * */
    public int treeDepth(TreeNode root) {
        // 终止条件
        if (root == null) {
            return 0;
        }

        //递归
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);

        return Math.max(leftDepth,rightDepth)+1;
    }



    private static int ret = 0;
    /**
     * 深度优先遍历
     * */
    public static int process(TreeNode root){
        dfs(root,0);
        return ret;
    }

    public static void dfs(TreeNode root , int depth){
        if (root != null) {
            ret = Math.max(ret,depth++);
            dfs(root.left,depth);
            dfs(root.right,depth);
        }
    }


    public static void main(String[] args) {
        int i=1;
        System.out.println(Math.max(0,i++));
        System.out.println(i);
    }

}
