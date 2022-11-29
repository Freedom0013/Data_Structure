package com.freedom.datastructure.graph;

import com.freedom.datastructure.linear.Queue;

/**
 * 加权无向图
 * @author Freedom0013 @Date 2022-11-29
 * @version V1.00
 */
public class EdgeWeightedGraph {
    /** 图定点数目 */
    private final int vertex;
    /** 图边的数目 */
    private int Edges;
    /** 邻接表 */
    private Queue<Edge>[] adjacencyList;

    /**
     * 构建加权有向图
     * @param vertex 顶点数量
     */
    public EdgeWeightedGraph(int vertex) {
        this.vertex = vertex;
        this.Edges = 0;
        this.adjacencyList = new Queue[vertex];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new Queue<Edge>();
        }
    }

    public int getEdge() {
        return Edges;
    }

    public int getVertex() {
        return vertex;
    }

    /**
     * 为加权无向图两个顶点添加一条边
     * @param edge 加权边
     */
    public void addEdge(Edge edge) {
        int v = edge.getEither();
        int w = edge.getOther(v);
        //无向图边v1-v2同时v2-v1
        adjacencyList[v].enqueue(edge);
        adjacencyList[w].enqueue(edge);
        Edges++;
    }

    /**
     * 获取vertex顶点相邻的所有边
     * @param vertex 顶点
     * @return com.freedom.datastructure.linear.Queue<com.freedom.datastructure.graph.Edge> 邻接队列
     */
    public Queue<Edge> getAdjacencyList(int vertex) {
        return adjacencyList[vertex];
    }

    /**
     * 获取加权无向图中所有边
     * @return com.freedom.datastructure.linear.Queue<com.freedom.datastructure.graph.Edge> 加权边队列
     */
    public Queue<Edge> edges() {
        Queue<Edge> allEdge = new Queue<>();
        for (int i = 0; i < vertex; i++) {
            for (Edge e : getAdjacencyList(i)) {
                if (e.getOther(i) < i) {
                    allEdge.enqueue(e);
                }
            }
        }
        return allEdge;
    }
}
