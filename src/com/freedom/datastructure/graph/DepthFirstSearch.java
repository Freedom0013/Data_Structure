package com.freedom.datastructure.graph;

/**
 * 图深度优先遍历
 * @author Freedom0013 @Date 2022-11-28
 * @version V1.00
 */
public class DepthFirstSearch {
    /** 索引代表顶点，值标识当前顶点是否被搜索过 */
    private boolean[] marked;
    /** 记录有多少个顶点与s顶点相连 */
    private int count;

    /**
     * 构造深度优先遍历对象，搜索找出graph图中s顶点的所有相邻顶点
     * @param graph 图
     * @param s 顶点
     */
    public DepthFirstSearch(Graph graph, int s) {
        this.marked = new boolean[graph.getVertex()];
        this.count = 0;
        depthFirstSearch(graph, s);
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
                depthFirstSearch(graph, w);
            }
        }
        count++;
    }

    /**
     * 判断w顶点是否与s顶点联通
     * @param w 顶点w
     * @return boolean 是否联通
     */
    public boolean mark(int w){
        return marked[w];
    }

    /** 获取顶点s相通的所有顶点总数 */
    public int getCount() {
        return count;
    }
}
