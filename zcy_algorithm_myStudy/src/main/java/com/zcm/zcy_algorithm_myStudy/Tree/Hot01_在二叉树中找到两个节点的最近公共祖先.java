package com.zcm.zcy_algorithm_myStudy.Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Hot01_在二叉树中找到两个节点的最近公共祖先 {
    public static int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        TreeNode node = process(root, o1, o2);
        return node.val;
    }

    public static TreeNode process(TreeNode root ,int o1,int o2){
        // 终止条件--如果root为空，在返回空的root
        if (root==null){
            return root;
        }

        // 如果root的val等于o1或者o2，则返回root节点
        if (root.val==o1 || root.val==o2){
            return root;
        }

        // 递归获得左右孩子节点
        TreeNode left = process(root.left, o1, o2);
        TreeNode right = process(root.right, o1, o2);

        // 如果左右孩子节点都不为空，则说明此时的root就是两个节点的最近公共祖先，则返回root
        if (left!=null && right!=null){
            return root;
        }
        // 返回left或者right中其中不为空的一个，后者两个都为空，则返回空节点
        return left!=null ? left : right;
    }



    public static TreeNode construct(int[] arr){
        ArrayList<TreeNode> list = new ArrayList<>();
        TreeNode root = new TreeNode(arr[0]);
        list.add(root);

        // 构建出一个个TreeNode节点，然后添加到list中
        for (int i=1;i<arr.length;i++){
            if (arr[i]!=-1){
                TreeNode node = new TreeNode(arr[i]);
                list.add(node);
                continue;
            }
            list.add(null);
        }

        // 然后给每个节点设置对应的左孩子和右孩子
        for (int i=0;i*2+2<list.size();i++){
            TreeNode cur = list.get(i);
            if (cur!=null){
                cur.left=list.get(2*i+1);
                cur.right=list.get(2*i+2);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String s = in.nextLine();
            String[] arr = s.split(",");
            int[] intArr = new int[arr.length];
            for(int i=0;i<arr.length;i++){
                intArr[i] = Integer.valueOf(arr[i]);
            }
            TreeNode root = construct(intArr);
            int i = lowestCommonAncestor(root, 5, 1);
            System.out.println(i);
        }
    }



}
