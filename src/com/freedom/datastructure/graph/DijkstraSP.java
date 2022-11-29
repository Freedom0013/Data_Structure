package com.freedom.datastructure.graph;

import com.freedom.datastructure.linear.Queue;
import com.freedom.datastructure.tree.heap.IndexMinPriorityQueue;

import java.util.Arrays;

/**
 * Dijkstra算法
 * @author Freedom0013 @Date 2022-11-29
 * @version V1.00
 */
public class DijkstraSP {
    /** 索引代表顶点，值表示从顶点s到当前顶点的最短路径上的最后一条边 */
    private DirectedEdge[] edgeTo;
    /** 索引代表顶点，值表示从顶点s到当前顶点最短路径的总权重 */
    private double[] distTo;
    /** 存放树中顶点与非树中顶点之间的有效横切边 */
    private IndexMinPriorityQueue<Double> pq;

    /**
     * 根据加权有向图和顶点s，创建一个顶点为s的最短路径树对象
     * @param edgeWeightedDigraph 加权有向图
     * @param s 顶点s
     */
    public DijkstraSP(EdgeWeightedDigraph edgeWeightedDigraph, int s) {
        this.edgeTo = new DirectedEdge[edgeWeightedDigraph.getVertex()];
        this.distTo = new double[edgeWeightedDigraph.getVertex()];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        this.pq = new IndexMinPriorityQueue<>(edgeWeightedDigraph.getVertex());
        distTo[0] = 0.0d;
        pq.insert(s, 0.0d);
        while (!pq.isEmpty()) {
            relax(edgeWeightedDigraph, pq.deleteMin());
        }
    }

    /**
     * 松弛顶点vertex
     * @param edgeWeightedDigraph 加权有向图
     * @param vertex 顶点vertex
     */
    private void relax(EdgeWeightedDigraph edgeWeightedDigraph, int vertex) {
        for (DirectedEdge directedEdge : edgeWeightedDigraph.getAdjacencyList(vertex)) {
            int w = directedEdge.to();
            //通过松弛技术判断从起点s到顶点w的最短路径是否需要先从顶点s到vertex，然后再由顶点vertex到顶点w
            if ((distTo(vertex) + directedEdge.getWeight()) < distTo(w)) {
                distTo[w] = distTo[vertex] + directedEdge.getWeight();
                edgeTo[w] = directedEdge;
                if (pq.contains(w)) {
                    pq.changeItem(w, distTo(w));
                } else {
                    pq.insert(w, distTo(w));
                }
            }
        }
    }

    /**
     * 获取从顶点s到vertex的最短路径总权重
     * @param vertex 顶点vertex
     * @return double 总权重
     */
    public double distTo(int vertex) {
        return distTo[vertex];
    }

    /**
     * 判断从顶点s到vertex是否可达
     * @param vertex 顶点vertex
     * @return boolean 是否可达
     */
    public boolean hasPathTo(int vertex) {
        return distTo[vertex] < Double.POSITIVE_INFINITY;
    }

    /**
     * 查询从起点s到顶点vertex的最短路径的所有边
     * @param vertex 顶点vertex
     * @return com.freedom.datastructure.linear.Queue<com.freedom.datastructure.graph.DirectedEdge> 邻接表
     */
    public Queue<DirectedEdge> pathTo(int vertex) {
        if (!hasPathTo(vertex)) {
            return null;
        }
        Queue<DirectedEdge> allEdge = new Queue<>();
        while (true) {
            DirectedEdge e = edgeTo[vertex];
            if (e == null) {
                break;
            }
            allEdge.enqueue(e);
            vertex = e.from();
        }
        return allEdge;
    }
}
