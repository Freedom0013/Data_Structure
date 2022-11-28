package com.freedom.datastructure.test;

import com.freedom.datastructure.graph.BreadthFirstSearch;
import com.freedom.datastructure.graph.DepthFirstSearch;
import com.freedom.datastructure.graph.Graph;

/**
 * 深度优先遍历测试
 * @author Freedom0013 @Date 2022-11-28
 * @version V1.00
 */
public class DepthFirstSearchTest {
    public static void main(String[] args) {
        Graph graph = new Graph(30);
        graph.addEdge(0,5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,6);
        graph.addEdge(5,3);
        graph.addEdge(5,4);
        graph.addEdge(3,4);
        graph.addEdge(4,6);

        graph.addEdge(7,8);

        graph.addEdge(9,11);
        graph.addEdge(9,10);
        graph.addEdge(9,12);
        graph.addEdge(11,12);

//        DepthFirstSearch search = new DepthFirstSearch(graph,0);
//        int count = search.getCount();
//        System.out.println("与0相通的顶点数量为："+count);
//
//        boolean mark1 = search.mark(5);
//        System.out.println("5和0是否相通："+mark1);
//        boolean mark2 = search.mark(7);
//        System.out.println("7和0是否相通："+mark2);

        BreadthFirstSearch search = new BreadthFirstSearch(graph,0);
        int count = search.getCount();
        System.out.println("与0相通的顶点数量为："+count);

        boolean mark1 = search.mark(5);
        System.out.println("5和0是否相通："+mark1);
        boolean mark2 = search.mark(7);
        System.out.println("7和0是否相通："+mark2);
    }
}
