package com.zcm.zcy_algorithm_myStudy.Tree;


/**
 * 树的子结构
 * https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=23293&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * */
public class JianZhi04_TheSubstructureOfTree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        // 终止条件
        if (root2==null) {
            return false;
        }
        if (root1==null && root2!=null) {
            return false;
        }
        if (root1!=null && root2==null){
            return true;
        }
        if (root1==null && root2==null) {
            return true;
        }

        // 递归判断 root2是不是root1的可选根结点
        boolean b1 = process(root1, root2);

        // 递归判断root2是不是root1左孩子的可选根结点
        boolean b2 = HasSubtree(root1.left, root2);

        // 递归判断root2是不是root1右孩子的可选根结点
        boolean b3 = HasSubtree(root1.right, root2);

        return b1 || b2 || b3;

    }


    /**
     * 同步递归判断root2是否可以作为root1的子结构
     * */
    public static boolean process(TreeNode root1,TreeNode root2){
        if (root1==null && root2!=null) {
            return false;
        }
        if (root1==null && root2==null){
            return true;
        }
        if (root1!=null && root2==null){
            return true;
        }

        // 如果root1和root2都不为空
        if (root1.val!= root2.val) {
            // 如果root1和root2的值不一样，直接返回false
            return false;
        }

        // 如果root1和root2的值是一样的，则递归他们的左右结点，判断是否一样
        return process(root1.left,root2.left) && process(root1.right,root2.right);

    }
}
