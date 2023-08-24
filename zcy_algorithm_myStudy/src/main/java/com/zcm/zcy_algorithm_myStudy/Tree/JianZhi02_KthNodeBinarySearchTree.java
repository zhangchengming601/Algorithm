package com.zcm.zcy_algorithm_myStudy.Tree;


import java.util.ArrayList;

/**
 * 二叉搜索树的第k个节点
 * https://www.nowcoder.com/practice/57aa0bab91884a10b5136ca2c087f8ff?tpId=13&tqId=2305268&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * */
public class JianZhi02_KthNodeBinarySearchTree {


    // 声明一个list，用于从小到大存放 node的val
    private static ArrayList<Integer> list = new ArrayList<>();
    public int KthNode (TreeNode proot, int k) {

        if (proot == null || k<1) {
            return -1;
        }
        // 递归遍历树的每个结点
        dfs(proot,k);

        if (k>list.size()){
            return -1;
        }
        return list.get(k-1);

    }

    public static void dfs(TreeNode proot, int k){
        if (proot==null) {
            return;
        }
        dfs(proot.left,k);
        list.add(proot.val);
        dfs(proot.right,k);

    }
}
