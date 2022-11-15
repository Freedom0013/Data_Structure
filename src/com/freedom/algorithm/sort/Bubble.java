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
     * 依次对比最大元素放入最大位置，稳定排序类型，时间复杂度：O(n^2)（for循环嵌套）
     * @param array 待排数组
     * @param isDesc 是否倒序
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
