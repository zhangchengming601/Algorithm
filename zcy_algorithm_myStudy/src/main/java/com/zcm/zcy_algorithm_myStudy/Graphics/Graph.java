package com.zcm.zcy_algorithm_myStudy.Graphics;


import java.util.HashMap;
import java.util.HashSet;

/**
 * 图数据结构
 * */
public class Graph {
    public HashMap<Integer,Node> nodes;  // 点集 其中key是node的id
    public HashSet<Edge> edges; // 边集

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
