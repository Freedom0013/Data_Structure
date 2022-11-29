package com.freedom.datastructure.test;

import com.freedom.datastructure.graph.Edge;
import com.freedom.datastructure.graph.EdgeWeightedGraph;
import com.freedom.datastructure.graph.KruskalMST;
import com.freedom.datastructure.graph.PrimMST;
import com.freedom.datastructure.linear.Queue;

/**
 * Prim算法测试
 * @author Freedom0013 @Date 2022-11-29
 * @version V1.00
 */
public class PrimTest {
    public static void main(String[] args) {
        EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(8);
        edgeWeightedGraph.addEdge(new Edge(4, 5, 0.35d));
        edgeWeightedGraph.addEdge(new Edge(4, 7, 0.37d));
        edgeWeightedGraph.addEdge(new Edge(5, 7, 0.28d));
        edgeWeightedGraph.addEdge(new Edge(0, 7, 0.16d));
        edgeWeightedGraph.addEdge(new Edge(1, 5, 0.32d));
        edgeWeightedGraph.addEdge(new Edge(0, 4, 0.38d));
        edgeWeightedGraph.addEdge(new Edge(2, 3, 0.17d));
        edgeWeightedGraph.addEdge(new Edge(1, 7, 0.19d));
        edgeWeightedGraph.addEdge(new Edge(0, 2, 0.26d));
        edgeWeightedGraph.addEdge(new Edge(1, 2, 0.36d));
        edgeWeightedGraph.addEdge(new Edge(1, 3, 0.29d));
        edgeWeightedGraph.addEdge(new Edge(2, 7, 0.34d));
        edgeWeightedGraph.addEdge(new Edge(6, 2, 0.40d));
        edgeWeightedGraph.addEdge(new Edge(3, 6, 0.52d));
        edgeWeightedGraph.addEdge(new Edge(6, 0, 0.58d));
        edgeWeightedGraph.addEdge(new Edge(6, 4, 0.93d));

//        PrimMST primMST = new PrimMST(edgeWeightedGraph);
//        Queue<Edge> edges = primMST.edges();

        KruskalMST kruskalMST = new KruskalMST(edgeWeightedGraph);
        Queue<Edge> edges = kruskalMST.edges();

        for (Edge edge : edges) {
            int v = edge.getEither();
            int w = edge.getOther(v);
            double weight = edge.getWeight();
            System.out.println(v + "-" + w + "::" + weight);
        }
    }
}
