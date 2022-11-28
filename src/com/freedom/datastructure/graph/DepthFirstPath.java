package com.freedom.datastructure.graph;

import com.freedom.datastructure.linear.Stack;

/**
 * 图的路径查找
 * @author Freedom0013 @Date 2022-11-28
 * @version V1.00
 */
public class DepthFirstPath {
    /** 索引代表顶点，值标识当前顶点是否被搜索过 */
    private boolean[] marked;
    /** 起点 */
    private int start;
    /** 索引代表顶点，值标识从起点start到当前顶点路径上的最后一个顶点 */
    private int[] edgeTo;

    /**
     * 构造深度优先遍历对象，搜索找出graph图中s顶点的所有相邻顶点
     * @param graph 图
     * @param s 顶点
     */
    public DepthFirstPath(Graph graph, int start) {
        this.marked = new boolean[graph.getVertex()];
        this.start = start;
        this.edgeTo = new int[graph.getVertex()];
        depthFirstSearch(graph, start);
    }

    /**
     * 使用深度优先搜索graph图中顶点vertex顶点的所有相连顶点
     * @param graph 图
     * @param vertex 顶点
     */
    private void depthFirstSearch(Graph graph, int vertex) {
        marked[vertex] = true;  //顶点vertex置为已搜索
        for (Integer w : graph.getAdjacencyList(vertex)) {
            //判断当前w顶点有没有被搜索过，如果没有被搜索过则递归调用dfs深度优先
            if (!marked[w]) {
                edgeTo[w] = vertex;
                depthFirstSearch(graph, w);
            }
        }
    }

    /**
     * 判断w顶点是否与s顶点联通
     * @param w 顶点w
     * @return boolean 是否联通
     */
    public boolean hasPathTo(int vertex) {
        return marked[vertex];
    }

    /**
     * 找出从start到vertex的路径
     * @param vertex 顶点v
     * @return com.freedom.datastructure.linear.Stack<java.lang.Integer> 路径栈
     */
    public Stack<Integer> pathTo(int vertex) {
        if (!hasPathTo(vertex)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = vertex; x != start; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(start);
        return path;
    }
}
