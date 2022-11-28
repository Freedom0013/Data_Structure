package com.freedom.datastructure.graph;

import com.freedom.datastructure.linear.Stack;

/**
 * 基于深度优先的顶点排序
 * @author Freedom0013 @Date 2022-11-28
 * @version V1.00
 */
public class DepthFirstOrder {
    /** 索引代表顶点，值标识当前顶点是否被搜索过 */
    private boolean[] marked;
    /** 使用栈存储顶点序列 */
    private Stack<Integer> reversePost;

    /**
     * 构建顶点排序
     * @param digraph 有向图
     */
    public DepthFirstOrder(Digraph digraph) {
        this.marked = new boolean[digraph.getVertex()];
        this.reversePost = new Stack<>();
        for (int i = 0; i < digraph.getVertex(); i++) {
            if(!marked[i]){
                depthFirstSearch(digraph,i);
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
        for (Integer w : digraph.getAdjacencyList(vertex)) {
            if (!marked[w]) {
                depthFirstSearch(digraph, w);
            }
        }
        reversePost.push(vertex);
    }

    /**
     * 获取顶点线性序列
     * @return com.freedom.datastructure.linear.Stack<java.lang.Integer>
     */
    public Stack<Integer> getReversePost() {
        return reversePost;
    }
}
