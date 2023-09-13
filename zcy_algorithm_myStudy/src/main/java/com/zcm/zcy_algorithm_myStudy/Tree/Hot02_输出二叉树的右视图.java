package com.zcm.zcy_algorithm_myStudy.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Hot02_输出二叉树的右视图 {
    public int[] solve (int[] preOrder, int[] inOrder) {
        TreeNode root = buildTree(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
        return process(root);
    }



    /**
     * 构造二叉树
     *
     * pre : 前序 集合
     * in : 中序 集合
     * preStrat : 前序的开始坐标
     * preEnd ： 前序的结束坐标
     * inStart : 中序的开始坐标
     * inEnd : 中序的结束坐标
     * */
    public static TreeNode buildTree(int[] preOrder, int[] inOrder,int preStrat, int preEnd, int inStart ,int inEnd){
        // 终止条件
        if(preStrat>preEnd || inStart>inEnd){
            // 当前序开始坐标大于前序结束坐标，或者中序开始坐标大于中序结束坐标的时候，直接返回
            return null;
        }

        // 递归逻辑

        // preValue : 当前的根节点的值
        int preValue = preOrder[preStrat];

        // 寻找根节点在中序遍历中的下标
        int rootInIndex = 0;
        for(int i=inStart;i<inOrder.length;i++){
            if(inOrder[i]==preValue){
                rootInIndex=i;
            }
        }

        // 构造当前根节点
        TreeNode root = new TreeNode(preValue);

        // 当前root的左子树大小
        int leftSize = rootInIndex-inStart;
        // 当前root的右子树大小
        int rightSize = inEnd-rootInIndex;

        // 递归构造左子树
        root.left = buildTree(preOrder,inOrder,preStrat+1,preStrat+leftSize,inStart,inStart+leftSize-1);
        // 递归构造右子树
        root.right = buildTree(preOrder,inOrder,preStrat+leftSize+1,preEnd,rootInIndex+1,inEnd);

        return root;
    }


    /**
     * 使用队列，迭代遍历右视图
     * */
    public static int[] process(TreeNode root){
        // 创建一个队列
        LinkedList<TreeNode> queue = new LinkedList<>();

        ArrayList<Integer> res = new ArrayList<>();

        // 先把根节点放进队列
        queue.add(root);
        while (queue.size()!=0){
            int n = queue.size();  // 当前层的长度

            for(int i=0;i<n;i++){
                TreeNode node = queue.removeFirst();
                if(i==n-1){
                    res.add(node.val);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        int[] arr = new int[res.size()];
        for(int i=0;i<arr.length;i++){
            arr[i] = res.get(i);
        }
        return arr;
    }
}
