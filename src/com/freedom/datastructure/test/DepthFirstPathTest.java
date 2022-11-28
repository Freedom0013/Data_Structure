package com.freedom.datastructure.test;

import com.freedom.datastructure.graph.DepthFirstPath;
import com.freedom.datastructure.graph.Graph;
import com.freedom.datastructure.linear.Stack;

/**
 * 深度优先图的路径查找测试
 * @author Freedom0013 @Date 2022-11-28
 * @version V1.00
 */
public class DepthFirstPathTest {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(0, 5);

        DepthFirstPath paths = new DepthFirstPath(graph, 0);
        Stack<Integer> path = paths.pathTo(4);
        StringBuffer stringBuffer = new StringBuffer();
        for (Integer v : path) {
            stringBuffer.append(v + "-");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        System.out.println(stringBuffer);

    }
}
