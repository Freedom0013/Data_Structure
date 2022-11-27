package com.freedom.datastructure.tree.heap;

import java.util.Arrays;

/**
 * 索引最大优先队列
 * @author Freedom0013 @Date 2022-11-27
 * @version V1.00
 */
public class IndexMaxPriorityQueue<T extends Comparable<T>> extends MaxPriorityQueue{
    /** 保存每个元素在items中的索引，pq数组需要堆有序 */
    private int[] pq;
    /** 保存pq数组的逆序，使用pq的索引作为qp的元素，pq的元素作为qp的索引 */
    private int[] qp;

    /**
     * 构造堆
     * @param capacity 堆大小
     */
    public IndexMaxPriorityQueue(int capacity) {
        super(capacity);
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];
        //默认情况下，qp未存储任何数据，使qp中元素均为-1
        Arrays.fill(qp, -1);
    }

    /**
     * 判断元素i是否小于元素j
     * @param i i索引
     * @param j j索引
     * @return boolean i是否小于j
     */
    protected boolean less(int i, int j) {
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    /**
     * 交换i、j元素值
     * @param i i索引
     * @param j j索引
     */
    protected void exch(int i, int j) {
        //交换pq元素
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        //更新qp数组
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    /**
     * 判断k索引处元素是否存在
     * @param k K索引
     * @return boolean 是否存在
     */
    public boolean contains(int k){
        if (isEmpty()) {
            return false;
        }
        return qp[k] != -1;
    }

    /**
     * 获取最小元素关联的索引值
     * @return int 最小元素索引
     */
    public int getMaxIndex(){
        if (isEmpty()) {
            return -1;
        }
        return pq[1];
    }

    /**
     * 获取i索引处元素值
     * @param i 索引i
     * @return T 元素值
     */
    public T getItem(int i) {
        return (T) items[i];
    }

    /**
     * 插入元素
     * @param i 元素关联的索引
     * @param t 元素值
     */
    public void insert(int i, T t) {
        if (contains(i)) {
            return;
        }
        size++;
        items[i] = t;
        pq[size] = i;
        qp[i] = size;
        swim(size);
    }

    /**
     * 删除i处元素
     * @param i 被删除索引值
     */
    public void delete(int i) {
        if (isEmpty()) {
            return;
        }
        int k = qp[i];  //找到i在pq中的索引
        exch(k, size);   //交换pq中k索引处的值和最大索引的值
        qp[pq[size]] = -1;  //各类删除
        pq[size] = -1;
        items[k] = null;
        size--;
        sink(k);        //调整k
        swim(k);
    }

    /**
     * 删除最小元素
     * @return int 最小元素关联的索引
     */
    public int deleteMin() {
        if (isEmpty()) {
            return -1;
        }
        int maxIndex = pq[1];   //获取最大元素值索引
        exch(1, size);      //交换pq处索引1处和最大索引处值等待删除
        qp[pq[size]] = -1;     //删除qp数组对应pq内容
        pq[size] = -1;      //删除pq中换下来的最小元素
        items[maxIndex] = null; //删除最小元素items原始值
        size--;         //元素个数-1
        sink(1);    //下沉调整刚刚临时换上来的堆顶元素
        return maxIndex;
    }


    /**
     * 替换索引i处的值为t
     * @param i 待替换索引值
     * @param t 替换值
     */
    public void changeItem(int i, T t) {
        if (isEmpty()) {
            return;
        }
        items[i] = t;
        int k = qp[i];
        sink(k);        //调整k
        swim(k);
    }
}
