package com.freedom.datastructure.graph;

import com.freedom.datastructure.linear.Queue;
import com.freedom.datastructure.tree.heap.IndexMinPriorityQueue;

import java.util.Arrays;

/**
 * Prim算法
 * @author Freedom0013 @Date 2022-11-29
 * @version V1.00
 */
public class PrimMST {
    /** 索引代表顶点，值表示当前顶点和最小生成树之间的最短边 */
    private Edge[] edgeTo;
    /** 索引代表顶点，值表示当前顶点和最小生成树之间的最短边的权重 */
    private double[] distTo;
    /** 索引代表顶点，如果当前顶点已经在树中，元素值为true，不在为false */
    private boolean[] marked;
    /** 存放树中顶点与非树中顶点之间的有效横切边 */
    private IndexMinPriorityQueue<Double> pq;

    /**
     * 根据一副加权无向图创建最小生成树
     * @param edgeWeightedGraph 加权无向图
     */
    public PrimMST(EdgeWeightedGraph edgeWeightedGraph) {
        this.edgeTo = new Edge[edgeWeightedGraph.getVertex()];
        this.distTo = new double[edgeWeightedGraph.getVertex()];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        this.marked = new boolean[edgeWeightedGraph.getVertex()];
        pq = new IndexMinPriorityQueue<>(edgeWeightedGraph.getVertex());
        //默认让顶点0进入树中，但是树中只有一个顶点0，因此顶点0默认没有与其他顶点相连，所以让distTo对应位置存储0.0
        distTo[0] = 0.0d;
        pq.insert(0, 0.0d);

        //遍历索引最小优先队列，拿到最小和N切边对应的顶点，把顶点加入到最小生成树中
        while (!pq.isEmpty()){
            visit(edgeWeightedGraph,pq.deleteMin());
        }

    }

    /**
     * 将顶点vertex添加到最小生成树中，并更新数据
     * @param edgeWeightedGraph 加权有向图
     * @param vertex 待添加顶点
     */
    private void visit(EdgeWeightedGraph edgeWeightedGraph, int vertex) {
        marked[vertex] = true;
        for (Edge edge : edgeWeightedGraph.getAdjacencyList(vertex)) {
            int w = edge.getOther(vertex);
            if (marked[w]) {
                continue;
            }
            if (edge.getWeight() < distTo[w]) {
                edgeTo[w] = edge;
                distTo[w] = edge.getWeight();
                if (pq.contains(w)) {
                    pq.changeItem(w, edge.getWeight());
                } else {
                    pq.insert(w, edge.getWeight());
                }
            }
        }
    }

    /**
     * 获取最小生成树的所有边
     * @return java.util.Queue<com.freedom.datastructure.graph.Edge> 边队列
     */
    public Queue<Edge> edges() {
        Queue<Edge> allEdge = new Queue<>();
        for (int i = 0; i < edgeTo.length; i++) {
            if (edgeTo[i] != null) {
                allEdge.enqueue(edgeTo[i]);
            }
        }
        return allEdge;
    }
}
