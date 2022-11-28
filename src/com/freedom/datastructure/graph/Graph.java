package com.freedom.datastructure.graph;

import com.freedom.datastructure.linear.Queue;

/**
 * 无向图
 * @author Freedom0013 @Date 2022-11-28
 * @version V1.00
 */
public class Graph {
    /** 图定点数目 */
    private final int vertex;
    /** 图边的数目 */
    private int Edge;
    /** 邻接表 */
    private Queue<Integer>[] adjacencyList;

    public Graph(int vertex) {
        this.vertex = vertex;
        this.Edge = 0;
        this.adjacencyList = new Queue[vertex];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new Queue<Integer>();
        }
    }

    /** 获取顶点数量 */
    public int getVertex() {
        return this.vertex;
    }

    /** 获取边数量 */
    public int getEdge() {
        return this.Edge;
    }

    /**
     * 为无向图两个顶点添加一条边
     * @param vertex1 顶点1
     * @param vertex2 顶点2
     */
    public void addEdge(int vertex1, int vertex2) {
        //无向图边v-w同时w-v
        adjacencyList[vertex1].enqueue(vertex2);
        adjacencyList[vertex2].enqueue(vertex1);
        Edge++;
    }

    /**
     * 获取vertex顶点相邻的所有顶点
     * @param vertex 顶点
     * @return com.freedom.datastructure.linear.Queue<java.lang.Integer> 邻接队列
     */
    public Queue<Integer> getAdjacencyList(int vertex) {
        return adjacencyList[vertex];
    }
}