package com.freedom.datastructure.graph;

import com.freedom.datastructure.linear.Queue;
import com.freedom.datastructure.tree.heap.MinPriorityQueue;
import com.freedom.datastructure.uf.UFTree;

/**
 * Kruskal算法
 * @author Freedom0013 @Date 2022-11-29
 * @version V1.00
 */
public class KruskalMST {
    /** 保存最小生成树边 */
    private Queue<Edge> mst;
    /** 索引代表顶点，使用并查集connect(v,m)可以判断顶点v与顶点m是否在同一棵树中，使用union方法可以将两个顶点所在的树合并 */
    private UFTree uf;
    /** 存储图中所有的边，使用最小优先队列，对边按照权重进行排序 */
    private MinPriorityQueue<Edge> pq;

    /**
     * 构造Kruskal算法
     * @param edgeWeightedGraph 加权无向图
     */
    public KruskalMST(EdgeWeightedGraph edgeWeightedGraph) {
        this.mst = new Queue<>();
        this.uf = new UFTree(edgeWeightedGraph.getVertex());
        //初始化pq，并把图中所有的边存储到pq中
        this.pq = new MinPriorityQueue<>(edgeWeightedGraph.getEdge() + 1);
        for (Edge edge : edgeWeightedGraph.edges()) {
            pq.insert(edge);
        }
        //遍历pq，拿到最小权重的边进行处理
        while (!pq.isEmpty() && (mst.size() < edgeWeightedGraph.getVertex() - 1)) {
            //找到权重最小的边
            Edge e = (Edge) pq.delete();
            int v = e.getEither();
            int w = e.getOther(v);
            //判断两个顶点是否在同一棵树中，在一起，不用处理，不再一起则合并树
            if (uf.connected(v, w)) {
                continue;
            }
            uf.union(v, w);
            //把边放入队列
            mst.enqueue(e);
        }
    }

    /**
     * 获取最小生成树的所有边
     * @return com.freedom.datastructure.linear.Queue<com.freedom.datastructure.graph.Edge> 边队列
     */
    public Queue<Edge> edges() {
        return mst;
    }
}
