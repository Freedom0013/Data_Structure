package com.freedom.datastructure.uf;

/**
 * 并查集实现
 * @author Freedom0013 @Date 2022-11-27
 * @version V1.00
 */
public class UF {
    /** 存储元素数组 */
    protected int[] eleAndGroup;
    /** 分组个数 */
    protected int count;

    public UF(int groupNum) {
        this.count = groupNum;
        this.eleAndGroup = new int[groupNum];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
    }

    /**
     * 获取当前有多少个分组
     * @return int 分组个数
     */
    public int getCount() {
        return count;
    }

    /**
     * 返回元素p所在的分组标识符
     * @param p 元素p
     * @return int 所在分组
     */
    public int find(int p) {
        return eleAndGroup[p];
    }

    /**
     * 判断元素p、q是否在同一组中
     * @param p 元素p
     * @param q 元素q
     * @return boolean 结果
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 把元素p所在分组与q元素所在分组合并
     * @param p 元素p
     * @param q 元素q
     */
    public void union(int p, int q) {
        if (connected(p, q)) {
            return;
        }
        int pGroup = find(p);
        int qGroup = find(q);
        for (int i = 0; i < eleAndGroup.length; i++) {
            if (eleAndGroup[i] == pGroup) {
                eleAndGroup[i] = qGroup;
            }
        }
        this.count--;
    }
}
