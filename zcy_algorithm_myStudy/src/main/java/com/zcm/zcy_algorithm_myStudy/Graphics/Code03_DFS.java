package com.zcm.zcy_algorithm_myStudy.Graphics;


import com.zcm.zcy_algorithm_myStudy.Graphics.entity.Node;

import java.util.HashSet;
import java.util.Stack;

/**
 * 图--深度优先遍历
 * */
public class Code03_DFS {
    public static void dfs(Node node) {
        if(node==null) {
            return ;
        }
        Stack<Node> stack=new Stack<Node>();
        HashSet<Node> set=new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.id);
        while(!stack.isEmpty()) {
            Node cur=stack.pop();
            for(Node next:cur.nexts) {
                if(!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.id);
                    break;
                }
            }
        }
    }
}
