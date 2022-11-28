package com.freedom.datastructure.test;

import com.freedom.datastructure.graph.Digraph;
import com.freedom.datastructure.graph.TopoLogical;
import com.freedom.datastructure.linear.Stack;

/**
 * 有向图拓扑排序测试
 * @author Freedom0013 @Date 2022-11-28
 * @version V1.00
 */
public class TopoLogicalTest {
    public static void main(String[] args) {
        Digraph digraph = new Digraph(6);
        digraph.addEdge(0, 2);
        digraph.addEdge(0, 3);
        digraph.addEdge(2, 4);
        digraph.addEdge(3, 4);
        digraph.addEdge(4, 5);
        digraph.addEdge(1, 2);

        TopoLogical topoLogical = new TopoLogical(digraph);
        Stack<Integer> order = topoLogical.getOrder();
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer w : order) {
            stringBuilder.append(w + "->");
        }
        String str = stringBuilder.toString();
        int index = str.lastIndexOf("->");
        str = str.substring(0, index);
        System.out.println(str);
    }
}
