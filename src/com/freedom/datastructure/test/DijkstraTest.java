package com.freedom.datastructure.test;

import com.freedom.datastructure.graph.*;
import com.freedom.datastructure.linear.Queue;

/**
 * Dijkstra算法测试
 * @author Freedom0013 @Date 2022-11-29
 * @version V1.00
 */
public class DijkstraTest {
    public static void main(String[] args) {
        EdgeWeightedDigraph edgeWeightedDigraph = new EdgeWeightedDigraph(8);
        edgeWeightedDigraph.addEdge(new DirectedEdge(4, 5, 0.35d));
        edgeWeightedDigraph.addEdge(new DirectedEdge(5, 4, 0.35d));
        edgeWeightedDigraph.addEdge(new DirectedEdge(4, 7, 0.37d));
        edgeWeightedDigraph.addEdge(new DirectedEdge(5, 7, 0.28d));
        edgeWeightedDigraph.addEdge(new DirectedEdge(7, 5, 0.28d));
        edgeWeightedDigraph.addEdge(new DirectedEdge(5, 1, 0.32d));
        edgeWeightedDigraph.addEdge(new DirectedEdge(0, 4, 0.38d));
        edgeWeightedDigraph.addEdge(new DirectedEdge(0, 2, 0.26d));
        edgeWeightedDigraph.addEdge(new DirectedEdge(7, 3, 0.39d));
        edgeWeightedDigraph.addEdge(new DirectedEdge(1, 3, 0.29d));
        edgeWeightedDigraph.addEdge(new DirectedEdge(2, 7, 0.34d));
        edgeWeightedDigraph.addEdge(new DirectedEdge(6, 2, 0.40d));
        edgeWeightedDigraph.addEdge(new DirectedEdge(3, 6, 0.52d));
        edgeWeightedDigraph.addEdge(new DirectedEdge(6, 0, 0.58d));
        edgeWeightedDigraph.addEdge(new DirectedEdge(6, 4, 0.93d));
        DijkstraSP kruskalMST = new DijkstraSP(edgeWeightedDigraph, 0);
        Queue<DirectedEdge> directedEdges = kruskalMST.pathTo(6);
        for (DirectedEdge directedEdge : directedEdges) {
            System.out.println(directedEdge.from() + "->" + directedEdge.to() + "::" + directedEdge.getWeight());
        }
    }
}
