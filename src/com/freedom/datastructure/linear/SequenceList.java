package com.freedom.datastructure.linear;

import java.util.Iterator;

/**
 * 线性表
 * @Author Freedom0013 @Date 2022-11-16
 * @Version V1.00
 */
public class SequenceList<T> implements Iterable<T>{
    /** 线性表存储元素的数组 */
    private T[] arrays;
    /** 线性表记录当前存储的元素个数 */
    private int size;

    /**
     * 构造一个线性表数据结构，默认内部存储数组长度为10，根据元素插入可变长度
     */
    public SequenceList() {
        this.arrays = (T[]) new Object[10];
        this.size = 0;
    }

    /**
     * 清空线性表
     */
    public void clear() {
        this.size = 0;
    }

    /**
     * 判断线性表是否为空
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 获取线性表长度
     */
    public int length() {
        return this.size;
    }

    /**
     * 插入元素
     * @param t 待存储元素对象
     */
    public void insert(T t) {
        if (size == arrays.length) {
            reSize(2 * arrays.length);  //插入元素时如果元素值超过内部数组存储上限则对内部数组进行扩容
        }
        arrays[size++] = t;
    }

    /**
     * 在index索引处插入元素
     * @param index 指定索引值
     * @param t 元素
     */
    public void insert(int index, T t) {
        if (size == arrays.length) {
            reSize(2 * arrays.length);
        }
        //先把index索引出的元素及其后面的元素统一向后移动一位，并把T插入index索引处
        for (int i = size; i > index; i--) {
            arrays[i] = arrays[i - 1];
        }
        arrays[index] = t;
        size++;
    }

    /**
     * 删除index索引处值并返回该元素
     * @param index 待删除索引值
     * @Return T 返回已删除的元素
     */
    public T remove(int index) {
        T current = arrays[index];
        for (int i = index; i < size - 1; i++) {    //删除数组元素时，元素从index处开始后面的由后向前依次前移，完成后数组容量减少1完成删除
            arrays[i] = arrays[i + 1];
        }
        this.size--;
        if (size < arrays.length / 4) {     //数组剩余元素小于数组的四分之一时，数组重新缩容为原先的二分之一
            reSize(arrays.length / 2);
        }
        return current;
    }

    /**
     * 返回元素t所在的索引值
     * @param t 元素
     * @Return int 元素所在索引
     */
    public int indexOf(T t) {
        if (t == null) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (arrays[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取index索引处元素值
     * @param index 索引值
     * @Return T 元素值
     */
    public T get(int index) {
        return arrays[index];
    }

    /**
     * 对内部数组长度进行可变后进行数组扩容或缩小
     * @param resize 新的内部数组容量值
     */
    private void reSize(int resize) {
        T[] temp = arrays;
        arrays = (T[]) new Object[resize];
        for (int i = 0; i < size; i++) {
            arrays[i] = temp[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SequenceIterator();
    }

    /** 线性表遍历迭代器 */
    private class SequenceIterator implements Iterator<T> {
        /** 迭代器指针 */
        private int cusor;

        public SequenceIterator() {
            this.cusor = 0;
        }

        @Override
        public boolean hasNext() {
            return cusor < size;
        }

        @Override
        public T next() {
            return arrays[cusor++];
        }
    }
}
