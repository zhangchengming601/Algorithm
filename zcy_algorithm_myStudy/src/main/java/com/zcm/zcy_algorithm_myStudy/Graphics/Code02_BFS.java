package com.zcm.zcy_algorithm_myStudy.Graphics;


import com.zcm.zcy_algorithm_myStudy.Graphics.entity.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 图--宽度优先遍历
 * */
public class Code02_BFS {
    // 从node出发，进行宽度优先遍历，只需要用到点结构
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        // 在二叉树进行宽度优先遍历时不会形成环
        // 但图会形成环，所以必须有个机制来确保每个结点只进一次队列
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.id);
            // 遍历当前结点的所有直接后继
            // 如果set中没有才加入set和队列
            for (Node next : node.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
