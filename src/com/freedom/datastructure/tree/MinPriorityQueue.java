package com.freedom.datastructure.tree;

/**
 * 最小优先队列
 * @author Freedom0013 @Date 2022-11-26
 * @version V1.00
 */
public class MinPriorityQueue<T extends Comparable<T>> extends Heap {
    /**
     * 构造小顶堆
     * @param capacity 小顶堆大小
     */
    public MinPriorityQueue(int capacity) {
        super(capacity);
    }

    @Override
    void swim(int k) {
        while (k > 1) {//堆中至少有两个节点时开始比较
            if (less(k, k / 2)) {//父节点大于当前节点
                exch(k, k / 2);
            }
            k = k / 2;  //找到父节点的父节点继续比较
        }
    }

    @Override
    void sink(int k) {
        //通过循环不断对比当前k节点和其左子节点2k及右子节点2k+1处的较大值元素，如果当前节点小，则互换位置
        while (2 * k <= size) {
            int min;//记录较小节点所在的索引
            if (2 * k + 1 <= size) {
                if (less(2 * k, 2 * k + 1)) {
                    min = 2 * k;
                } else {
                    min = 2 * k + 1;
                }
            } else {
                min = 2 * k;
            }
            //比较当前节点和较小值，注这里判断与大顶堆区别
            if (less(k, min)) {
                break;
            }
            exch(k, min);
            k = min;
        }
    }
}
