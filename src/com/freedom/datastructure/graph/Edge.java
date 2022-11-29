package com.freedom.datastructure.graph;

/**
 * 加权无向图边
 * @author Freedom0013 @Date 2022-11-29
 * @version V1.00
 */
public class Edge implements Comparable<Edge>{
    /** 顶点1 */
    private final int v;
    /** 顶点2 */
    private final int w;
    /** 当前边的权重 */
    private final double weight;

    /**
     * 构造加权无向边
     * @param v 顶点1
     * @param w 顶点2
     * @param weight 权重
     */
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 获取边权重
     * @return double 权重值
     */
    public double getWeight() {
        return weight;
    }

    /**
     * 获取边其中一个顶点
     * @return int 其中一个顶点
     */
    public int getEither() {
        return v;
    }

    /**
     * 获取边另一个顶点
     * @param vertex 已知的顶点
     * @return int 另一个顶点
     */
    public int getOther(int vertex) {
        if (vertex == v) {
            return w;
        } else {
            return v;
        }
    }

    //比较权值
    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }
}
