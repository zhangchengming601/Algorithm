package com.zcm.zcy_algorithm_myStudy.Tree;


import java.util.Arrays;
import java.util.List;

/**
 * 重建二叉树
 * https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=23282&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * */
public class JianZhi03_RebuildBinaryTree {
    public TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        if (preOrder.length==0 || vinOrder.length==0) {
            return null;
        }

        TreeNode curRoot = new TreeNode(preOrder[0]);

        // 在for循环中  preOrder[0]在vinOrder中出现的位置
        for (int i=0; i<preOrder.length; i++){
            if (vinOrder[i] == preOrder[0]) {
                curRoot.left = reConstructBinaryTree(Arrays.copyOfRange(preOrder,1,i+1),Arrays.copyOfRange(vinOrder,0,i));
                curRoot.right = reConstructBinaryTree(Arrays.copyOfRange(preOrder,i+1,preOrder.length),Arrays.copyOfRange(vinOrder,i+1,preOrder.length));
                break;
            }
        }
        return curRoot;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        System.out.println(Arrays.copyOfRange(arr,0,2));
    }
}
