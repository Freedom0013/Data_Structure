package com.freedom.datastructure.tree;

import java.util.Arrays;

/**
 * 索引最小优先队列
 * 为堆中所有数据关联一个索引
 *
 * T[] items;
 *      0   1   2   3   4   5   6   7   8   9   10  11
 *      S   O   R   T   E   X   A   M   P   L   E
 * int[] qp 存放堆调整后的顺序后，items中元素的索引
 *      0   1   2   3   4   5   6   7   8   9   10  11
 *      -   6   10  4   9   7   1   8   2   0   3   5
 * int[] qp 存放pq数组的逆序
 *      0   1   2   3   4   5   6   7   8   9   10  11
 *      9   6   8   10  3   11  1   5   7   4   2   -
 *
 * @author Freedom0013 @Date 2022-11-27
 * @version V1.00
 */
public class IndexMinPriorityQueue<T extends Comparable<T>> {
    /** 数组存储堆中元素 */
    private T[] items;
    /** 堆大小 */
    private int size;
    /** 保存每个元素在items中的索引，pq数组需要堆有序 */
    private int[] pq;
    /** 保存pq数组的逆序，使用pq的索引作为qp的元素，pq的元素作为qp的索引 */
    private int[] qp;

    /**
     * 构造堆
     * @param capacity 堆大小
     */
    public IndexMinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.size = 0;
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];
        //默认情况下，qp未存储任何数据，使qp中元素均为-1
        Arrays.fill(qp, -1);
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
    private boolean less(int i, int j) {
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    /**
     * 交换i、j元素值
     * @param i i索引
     * @param j j索引
     */
    private void exch(int i, int j) {
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
        return qp[k] != -1;
    }

    /**
     * 获取最小元素关联的索引值
     * @return int 最小元素索引
     */
    public int getMinIndex(){
        return pq[1];
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
     * 删除最小元素
     * @return int 最小元素关联的索引
     */
    public int deleteMin() {
        int minIndex = pq[1];   //获取最小元素值索引
        exch(1, size);      //交换pq处索引1处和最大索引处值等待删除
        qp[pq[size]] = -1;     //删除qp数组对应pq内容
        pq[size] = -1;      //删除pq中换下来的最小元素
        items[minIndex] = null; //删除最小元素items原始值
        size--;         //元素个数-1
        sink(1);    //下沉调整刚刚临时换上来的堆顶元素
        return minIndex;
    }

    /**
     * 删除i处元素
     * @param i 被删除索引值
     */
    public void delete(int i) {
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
     * 替换索引i处的值为t
     * @param i 待替换索引值
     * @param t 替换值
     */
    public void changeItem(int i, T t) {
        items[i] = t;
        int k = qp[i];
        sink(k);        //调整k
        swim(k);
    }

    private void swim(int k){
        while (k > 1) {//堆中至少有两个节点时开始比较
            if (less(k, k / 2)) {//父节点大于当前节点
                exch(k, k / 2);
            }
            k = k / 2;  //找到父节点的父节点继续比较
        }
    }

    private void sink(int k){
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
