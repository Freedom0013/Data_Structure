package com.freedom.datastructure.graph;

import com.freedom.datastructure.linear.Queue;

/**
 * 加权有向图
 * @author Freedom0013 @Date 2022-11-29
 * @version V1.00
 */
public class EdgeWeightedDigraph {
    /** 图定点数目 */
    private final int vertex;
    /** 图边的数目 */
    private int Edges;
    /** 邻接表 */
    private Queue<DirectedEdge>[] adjacencyList;

    /**
     * 构造加权有向图
     * @param vertex 节点数量
     * @return null
     */
    public EdgeWeightedDigraph(int vertex) {
        this.vertex = vertex;
        this.Edges = 0;
        this.adjacencyList = new Queue[vertex];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new Queue<DirectedEdge>();
        }
    }

    public int getVertex() {
        return vertex;
    }

    public int getEdges() {
        return Edges;
    }

    /**
     * 为加权有向图两个顶点添加一条边
     * @param directedEdge 加权边
     */
    public void addEdge(DirectedEdge directedEdge) {
        int v = directedEdge.from();
        adjacencyList[v].enqueue(directedEdge);
        Edges++;
    }

    /**
     * 获取vertex顶点相邻的所有边
     * @param vertex 顶点
     * @return com.freedom.datastructure.linear.Queue<com.freedom.datastructure.graph.DirectedEdge> 邻接队列
     */
    public Queue<DirectedEdge> getAdjacencyList(int vertex) {
        return adjacencyList[vertex];
    }

    /**
     * 获取加权有向图中所有边
     * @return com.freedom.datastructure.linear.Queue<com.freedom.datastructure.graph.Edge> 加权边队列
     */
    public Queue<DirectedEdge> edges() {
        Queue<DirectedEdge> allEdge = new Queue<>();
        for (int i = 0; i < vertex; i++) {
            for (DirectedEdge e : getAdjacencyList(i)) {
                allEdge.enqueue(e);
            }
        }
        return allEdge;
    }
}
