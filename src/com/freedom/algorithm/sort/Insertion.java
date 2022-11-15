package com.freedom.algorithm.sort;

import com.freedom.common.Tools;

/**
 * 插入排序
 * @Author Freedom0013 @Date 2022-11-15
 * @Version V1.00
 */
public class Insertion {
    /**
     * 插入排序
     * 数组分为已排序和未排序两部分，拿到未排序的第一个元素，遍历已排序部分，找到合适的位置将未排序元素比较后插入，稳定排序，时间复杂度：O(n^2)（for循环嵌套）
     * @param array 待排数组
     * @param isDesc 是否倒序
     * @Return java.lang.Comparable<T>[]
     * @Author Freedom0013 @Date 2022-11-15
     */
    public static <T> Comparable<T>[] InsertionSort(Comparable<T>[] array, boolean isDesc) {
        if (array == null || array.length < 2) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (isDesc ? Tools.greater(array[j], array[j - 1]) : Tools.greater(array[j - 1], array[j])) {
                    Tools.exch(array, j - 1, j);
                } else {
                    break;
                }
            }
        }
        return array;
    }
}
