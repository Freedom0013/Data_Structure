package com.freedom.datastructure.uf;

import java.util.Arrays;

/**
 * 并查集优化实现
 * union时间复杂度O(1),find()时间复杂度最坏O(N)
 * @author Freedom0013 @Date 2022-11-27
 * @version V1.00
 */
public class UFTree extends UF{
    /** 用来存储每一个根节点对应树中节点的个数 */
    private int[] sz;

    public UFTree(int groupNum) {
        super(groupNum);
        this.sz = new int[groupNum];
        Arrays.fill(sz, 1);
    }

    /**
     * 返回元素p所在的分组标识符
     * @param p 元素p
     * @return int 所在分组
     */
    public int find(int p) {
        while (true) {
            if (p == super.eleAndGroup[p]) {
                return p;
            }
            p = eleAndGroup[p];
        }
    }

    /**
     * 把元素p所在分组与q元素所在分组合并
     * @param p 元素p
     * @param q 元素q
     */
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        if (sz[pRoot] < sz[qRoot]) {
            eleAndGroup[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            eleAndGroup[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        super.count--;
    }
}
