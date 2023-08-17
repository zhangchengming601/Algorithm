package com.zcm.zcy_algorithm_myStudy.Graphics.entity;


import java.util.ArrayList;

/**
 * 图中点结构的描述
 * */
public class Node {
    public int id;  // id 是该node的编号
    public int in;  // in: 表示该node的入度
    public int out; // out : 表示该node的出度
    public ArrayList<Node> nexts;  // nexts : 表示该node的直接邻居
    public ArrayList<Edge> edges;  // edges : 表示该node的边

    public Node(int id){
        this.id = id;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<Edge>();
    }

}
