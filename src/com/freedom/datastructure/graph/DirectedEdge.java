package com.freedom.datastructure.graph;

/**
 * 加权有向边
 * @author Freedom0013 @Date 2022-11-29
 * @version V1.00
 */
public class DirectedEdge {
    /** 顶点1 */
    private final int v;
    /** 顶点2 */
    private final int w;
    /** 当前边的权重 */
    private final double weight;

    /**
     * 构造加权有向边
     * @param v 顶点1
     * @param w 顶点2
     * @param weight 权重
     */
    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 获取有向边起点
     * @return int 起点
     */
    public int from() {
        return v;
    }

    /**
     * 获取有向边终点
     * @return int 终点
     */
    public int to() {
        return w;
    }

    /**
     * 获取权重
     * @return double 权重
     */
    public double getWeight() {
        return weight;
    }
}
