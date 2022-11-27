package com.freedom.datastructure.tree.heap;

/**
 * 最大优先队列(大顶堆存储实现)
 * @author Freedom0013 @Date 2022-11-24
 * @version V1.00
 */
public class MaxPriorityQueue<T extends Comparable<T>> extends Heap{
    /**
     * 构造大顶堆
     * @param capacity 大顶堆大小
     */
    public MaxPriorityQueue(int capacity) {
        super(capacity);
    }

    @Override
    void swim(int k) {
        while (k > 1) {//堆中至少有两个节点时开始比较
            if (less(k / 2, k)) {//父节点小于当前节点
                exch(k / 2, k);
            }
            k = k / 2;  //找到父节点的父节点继续比较
        }
    }

    @Override
    void sink(int k) {
        //通过循环不断对比当前k节点和其左子节点2k及右子节点2k+1处的较大值元素，如果当前节点小，则互换位置
        while (2 * k <= size) {
            int max;//记录较大节点所在的索引
            if (2 * k + 1 <= size) {
                if (less(2 * k, 2 * k + 1)) {
                    max = 2 * k + 1;
                } else {
                    max = 2 * k;
                }
            } else {
                max = 2 * k;
            }
            //比较当前节点和较大值
            if (!less(k, max)) {
                break;
            }
            exch(k, max);
            k = max;
        }
    }
}
