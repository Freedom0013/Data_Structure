package com.freedom.datastructure.tree;

import com.freedom.common.Tools;

/**
 * 堆实现
 * 利用完全二叉树（根节点大于其叶子节点）与数组进行存储
 * @author Freedom0013 @Date 2022-11-21
 * @version V1.00
 */
public class Heap<T extends Comparable<T>> {
    /** 数组存储堆中元素 */
    private T[] items;
    /** 堆大小 */
    private int size;

    /**
     * 构造堆
     * @param capacity 堆大小
     */
    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.size = 0;
    }

    /**
     * 判断元素i是否小于元素j
     * @param i i索引
     * @param j j索引
     * @return boolean i是否小于j
     */
    private boolean less(int i, int j) {
//        if (items[i] == null || items[j] == null) {
//            return false;
//        }
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * 交换i、j元素值
     * @param i i索引
     * @param j j索引
     */
    private void exch(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    /**
     * 插入元素
     * @param t 元素
     */
    public void insert(T t) {
        items[++size] = t;  //数组在存元素的是否会把第一个元素废弃掉，故先++再存
        swim(size);
    }

    /**
     * 使用上浮算法使k处元素在堆中处在合适的位置
     * 通过循环不断比较当前节点与其父节点的值，如果当前节点比父节点大，则交换元素完成上浮
     * @param k k索引
     */
    private void swim(int k) {
        while (k > 1) {//堆中至少有两个节点时开始比较
            if (less(k / 2, k)) {//父节点小于当前节点
                exch(k / 2, k);
            }
            k = k / 2;  //找到父节点的父节点继续比较
        }
    }

    /**
     * 删除堆中最大元素
     * @return T 被删除的最大元素
     */
    public T deleteMax() {
        //交换当前根节点与最大索引处的元素，让完全二叉树最右边的子节点临时变为根节点
        T max = items[1];
        exch(1, size);
        //删除替换下来的最大元素
        items[size] = null;
        size--;
        //为临时根节点进行下沉操作
        sink(1);
        return max;
    }

    /**
     * 使用下沉算法使k处元素在堆中处在合适的位置
     * @param k k索引
     */
    private void sink(int k) {
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
