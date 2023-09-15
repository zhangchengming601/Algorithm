package com.zcm.zcy_algorithm_myStudy.MyTest.FunPlus_0915;



/**
 * 左叶子之和
 *
 * */
public class Main01 {

    public int sumOfLeftLeaves (TreeNode root) {
        int res =0;
        if(root.left!=null){
            res += (root.left.left==null && root.left.right==null) ? root.left.val : sumOfLeftLeaves(root.left);
        }
        if(root.right!=null){
            res += (root.right.left==null && root.right.right==null) ? 0 : sumOfLeftLeaves(root.right);
        }
        return res;

    }
}
