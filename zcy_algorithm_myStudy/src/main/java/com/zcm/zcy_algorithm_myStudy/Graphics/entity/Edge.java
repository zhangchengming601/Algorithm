package com.zcm.zcy_algorithm_myStudy.Graphics.entity;


/**
 * 图中边结构的描述
 */
public class Edge {
    public int weight; // 该边的权重
    public Node from;  // 该边从哪里出发
    public Node to;  // 该边去向哪里

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
