package com.freedom.datastructure.graph;

import com.freedom.datastructure.linear.Queue;

/**
 * 广度优先遍历
 * @author Freedom0013 @Date 2022-11-28
 * @version V1.00
 */
public class BreadthFirstSearch {
    /** 索引代表顶点，值标识当前顶点是否被搜索过 */
    private boolean[] marked;
    /** 记录有多少个顶点与s顶点相连 */
    private int count;
    /** 用来存储等待搜索的邻接表的点 */
    private Queue<Integer> waitSearch;

    /**
     * 构造广度优先遍历对象，搜索找出graph图中s顶点的所有相邻顶点
     * @param graph 图
     * @param s 顶点
     */
    public BreadthFirstSearch(Graph graph, int start) {
        this.marked = new boolean[graph.getVertex()];
        this.count = 0;
        this.waitSearch = new Queue<Integer>();
        breadthFirstSearch(graph, start);
    }

    /**
     * 使用广度优先搜索graph图中顶点vertex顶点的所有相连顶点
     * @param graph 图
     * @param vertex 顶点
     */
    private void breadthFirstSearch(Graph graph, int vertex) {
        marked[vertex] = true;
        waitSearch.enqueue(vertex);
        while (!waitSearch.isEmpty()) {
            Integer wait = waitSearch.dequeue();
            for (Integer w : graph.getAdjacencyList(wait)) {
                if (!marked[w]) {
                    breadthFirstSearch(graph, w);
                }
            }
        }
        count++;
    }

    /**
     * 判断w顶点是否与s顶点联通
     * @param w 顶点w
     * @return boolean 是否联通
     */
    public boolean mark(int w) {
        return marked[w];
    }

    /**
     * 获取顶点s相通的所有顶点总数
     */
    public int getCount() {
        return count;
    }
}
