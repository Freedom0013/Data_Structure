package com.freedom.algorithm.sort;

import com.freedom.common.Tools;

/**
 * 选择排序
 * @author Freedom0013 @date 2022-11-15
 * @version V1.00
 */
public class Selection {
    /**
     * 选择排序
     * 每次排序都与第一位最小值进行比较，入更小则两数交换，最终循环比较交换完成排序，不稳定排序，时间复杂度：O(n^2)（for循环嵌套）
     * @param array 待排数组
     * @param isDesc 是否倒序
     * @return java.lang.Comparable<T>[] 已排序数组
     */
    public static <T> Comparable<T>[] selectionSort(Comparable<T>[] array, boolean isDesc) {
        if (array == null || array.length < 2) {
            return array;
        }
        for (int i = 0; i <= array.length - 2; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (isDesc ? Tools.greater(array[j], array[minIndex]) : Tools.greater(array[minIndex], array[j])) {
                    minIndex = j;
                }
            }
            Tools.exch(array, i, minIndex);
        }
        return array;
    }
}
