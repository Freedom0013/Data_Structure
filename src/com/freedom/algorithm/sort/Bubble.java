package com.freedom.algorithm.sort;

import com.freedom.common.Tools;

/**
 * 冒泡排序
 * @Author Freedom0013 @Date 2022-11-14
 * @Version V1.00
 */
public class Bubble {
    /**
     * 冒泡排序
     * @param array 待排数组
     * @Return void
     * @Author Freedom0013 @Date 2022-11-15
     */
    public static <T> Comparable<T>[] bubbleSort(Comparable<T>[] array, boolean isDesc) {
        if (array == null || array.length < 2) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j <= array.length - 1; j++) {
                if (isDesc ? Tools.greater(array[j], array[i]) : Tools.greater(array[i], array[j])) {
                    Tools.exch(array, i, j);
                }
            }
        }
        return array;
    }
}
