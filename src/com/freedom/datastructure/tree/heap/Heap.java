package com.freedom.datastructure.tree.heap;

/**
 * 堆框架
 * 利用完全二叉树（根节点大于其叶子节点）与数组进行存储
 * @author Freedom0013 @Date 2022-11-21
 * @version V1.00
 */
public abstract class Heap<T extends Comparable<T>> {
    /** 数组存储堆中元素 */
    protected T[] items;
    /** 堆大小 */
    protected int size;

    /**
     * 构造堆
     * @param capacity 堆大小
     */
    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断元素i是否小于元素j
     * @param i i索引
     * @param j j索引
     * @return boolean i是否小于j
     */
    protected boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * 交换i、j元素值
     * @param i i索引
     * @param j j索引
     */
    protected void exch(int i, int j) {
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
     * 删除堆中元素
     * @return T 被删除的元素
     */
    public T delete() {
        //交换当前根节点与最大索引处的元素，让完全二叉树最右边的子节点临时变为根节点
        T item = items[1];
        exch(1, size);
        //删除替换下来的堆末尾元素
        items[size] = null;
        size--;
        //为临时根节点进行下沉操作
        sink(1);
        return item;
    }

    /**
     * 抽象方法：使用上浮算法使k处元素在堆中处在合适的位置
     * 通过循环不断比较当前节点与其父节点的值，如果当前节点比父节点大或小，则交换元素完成上浮
     * @param k k索引
     */
    abstract void swim(int k);

    /**
     * 抽象方法：使用下沉算法使k处元素在堆中处在合适的位置
     * @param k k索引
     */
    abstract void sink(int k);
}
