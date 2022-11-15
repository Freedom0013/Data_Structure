package com.freedom.algorithm.sort;

import com.freedom.common.Tools;

/**
 * 选择排序
 * @Author Freedom0013 @Date 2022-11-15
 * @Version V1.00
 */
public class Selection {
    public static <T> Comparable<T>[] SelectionSort(Comparable<T>[] array, boolean isDesc) {
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
