package com.freedom.datastructure.graph;

import com.freedom.datastructure.linear.Stack;

/**
 * 有向图拓扑排序
 * @author Freedom0013 @Date 2022-11-28
 * @version V1.00
 */
public class TopoLogical {
    /** 顶点的拓扑排序 */
    private Stack<Integer> order;

    /**
     * 构建拓扑排序
     * @param digraph 有向图
     */
    public TopoLogical(Digraph digraph) {
        DirectedCycle cycle = new DirectedCycle(digraph);
        if (!cycle.hasCycle()) {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph);
            order = depthFirstOrder.getReversePost();
        }
    }

    /**
     * 是否有环
     * @return boolean 是否有环
     */
    private boolean isCycle() {
        return order == null;
    }

    /**
     * 获取拓扑排序栈
     * @return com.freedom.datastructure.linear.Stack<java.lang.Integer> 拓扑排序栈
     */
    public Stack<Integer> getOrder() {
        return order;
    }
}
