package com.freedom.datastructure.graph;

/**
 * 检测有向图中的环
 * @author Freedom0013 @Date 2022-11-28
 * @version V1.00
 */
public class DirectedCycle {
    /** 索引代表顶点，值标识当前顶点是否被搜索过 */
    private boolean[] marked;
    /** 记录图中是否有环 */
    private boolean hasCycle;
    /** 索引代表顶点，使用栈的思想，记录当前顶点有没有已经处于正在搜索的有向路径上 */
    private boolean[] onStack;

    /**
     * 遍历有向图判断是否有环
     * @param digraph 有向图
     */
    public DirectedCycle(Digraph digraph) {
        this.marked = new boolean[digraph.getVertex()];
        this.hasCycle = false;
        this.onStack = new boolean[digraph.getVertex()];
        for (int i = 0; i < digraph.getVertex(); i++) {
            if (!marked[i]) {
                depthFirstSearch(digraph, i);
            }
        }
    }


    /**
     * 使用深度优先搜索graph图中顶点vertex顶点的所有相连顶点
     * @param digraph 图
     * @param vertex 顶点
     */
    private void depthFirstSearch(Digraph digraph, int vertex) {
        marked[vertex] = true;  //顶点vertex置为已搜索
        onStack[vertex] = true;
        for (Integer w : digraph.getAdjacencyList(vertex)) {
            if (!marked[w]) {
                depthFirstSearch(digraph, w);
            }
            if (onStack[w]) {
                hasCycle = true;
                return;
            }
        }
        onStack[vertex] = false;
    }

    /**
     * 获取有向图是否有环
     * @return boolean 是否有环
     */
    public boolean hasCycle() {
        return hasCycle;
    }
}
