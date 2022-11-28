package com.freedom.datastructure.graph;

import com.freedom.datastructure.linear.Queue;

/**
 * 有向图
 * @author Freedom0013 @Date 2022-11-28
 * @version V1.00
 */
public class Digraph {
    /** 图定点数目 */
    private final int vertex;
    /** 图边的数目 */
    private int Edge;
    /** 邻接表 */
    private Queue<Integer>[] adjacencyList;

    /**
     * 构造有向图
     * @param vertex 顶点数量
     */
    public Digraph(int vertex) {
        this.vertex = vertex;
        this.Edge = 0;
        this.adjacencyList = new Queue[vertex];

        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new Queue<>();
        }
    }

    public int getVertex() {
        return this.vertex;
    }

    public int getEdge() {
        return this.Edge;
    }

    /**
     * 为有向图两个顶点添加一条边
     * @param vertex1 顶点1
     * @param vertex2 顶点2
     */
    public void addEdge(int vertex1, int vertex2) {
        //有向图边v1-w2
        adjacencyList[vertex1].enqueue(vertex2);
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

    /**
     * 获取该图的反向图
     * @return com.freedom.datastructure.graph.Digraph 反转有向图对象
     */
    private Digraph reverse() {
        Digraph re = new Digraph(vertex);
        for (int i = 0; i < vertex; i++) {
            for (Integer w : adjacencyList[i]) {
                re.addEdge(w, i);
            }
        }
        return re;
    }
}
