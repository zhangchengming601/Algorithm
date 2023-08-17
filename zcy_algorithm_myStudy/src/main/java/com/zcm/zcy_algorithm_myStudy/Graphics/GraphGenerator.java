package com.zcm.zcy_algorithm_myStudy.Graphics;

public class GraphGenerator {

    /**
     * Integer[][] matrix : matrix是一个N×3的矩阵
     * matrix中每一行都表示一条边上的信息
     * matrix每一行上的数据分别表示 [weight(该边的权重) , fromId(该边的起始node的id)，toId(该边的终止的node的id)]
     * */
    public static Graph createGraph(Integer[][] matrix){
        Graph graph = new Graph();
        for (int i=0; i<matrix.length; i++){
            // [weight(该边的权重) , fromId(该边的起始node的id)，toId(该边的终止的node的id)]
            Integer weight = matrix[i][0];
            Integer fromId = matrix[i][1];
            Integer toId = matrix[i][2];

            // 向graph中添加该边的起始node
            if(!graph.nodes.containsKey(fromId)) {
                graph.nodes.put(fromId,new Node(fromId));
            }
            // 向graph中添加该边的终止node
            if(!graph.nodes.containsKey(toId)) {
                graph.nodes.put(toId,new Node(toId));
            }

            // 获得起始node和终止node
            Node fromNode = graph.nodes.get(fromId);
            Node toNode = graph.nodes.get(toId);
            Edge edge = new Edge(weight, fromNode, toNode);

            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }
        return graph;
    }
}
