package com.freedom.algorithm.sort;

import com.freedom.common.Tools;

/**
 * 归并排序
 * @author Freedom0013 @date 2022-11-15
 * @version V1.00
 */
public class Merge{
    /** 归并所需的辅助数组 */
    private static Comparable<Integer>[] assist;

    /**
     * 归并排序
     * 尽可能拆分源数组为元素相同的子组，并对每个子组继续拆分直到子组元素为个数为1。将两个相邻的子组合并为一个有序的大组，循环执行合并完成排序。
     * 分治、递归思想，稳定排序，时间复杂度：O(nLogN)
     * @param array 待排数组
     * @param isDesc 是否倒序
     */
    public static void mergeSort(Comparable<Integer>[] array, boolean isDesc) {
        if (array == null || array.length < 2) {
            return;
        }
        //初始化辅助数组
        assist = new Integer[array.length];
        //记录数组最小索引和最大索引值
        int low = 0;
        int high = array.length - 1;
        mergeSort(array, low, high, isDesc);
    }

    /**
     * 对数组array中，从low到high进行排序
     * @param array 待排数组
     * @param low 元素下限
     * @param high 元素上限
     * @param isDesc 是否倒序
     */
    private static void mergeSort(Comparable<Integer>[] array, int low, int high, boolean isDesc) {
        if (array == null || array.length < 2) {
            return;
        }
        //安全值校验
        if (high <= low) {
            return;
        }
        //根据最大索引和最小索引得出中间值并以此将两个数组一分为二
        int mid = low + (high - low) / 2;
        //分别对每个子数组进行排序
        mergeSort(array, low, mid, isDesc);
        mergeSort(array, mid + 1, high, isDesc);
        //将两个子数组进行归并
        merge(array, low, mid, high, isDesc);
    }

    /**
     * 对数组中两个子组（1.从low到mid、2从mid+1到high）进行归并
     * @param array 待存数组
     * @param low 元素下限
     * @param mid 中间元素
     * @param high 元素上限
     */
    private static void merge(Comparable<Integer>[] array, int low, int mid, int high, boolean isDesc) {
        //三个指针
        int index = low;
        int pos1 = low;
        int pos2 = mid + 1;

        //遍历移动1指针和2指针。比较对应索引的值后放入辅助数组
        while (pos1 <= mid && pos2 <= high) {
            if (isDesc ? Tools.greater(array[pos1], array[pos2]) : Tools.greater(array[pos2], array[pos1])) {
                assist[index++] = array[pos1++];
            } else {
                assist[index++] = array[pos2++];
            }
        }

        //如果1指针未走完，继续执行完成1指针，并放入辅助数组
        while (pos1 <= mid) {
            assist[index++] = array[pos1++];
        }

        //如果2指针未走完，继续执行完成2指针，并放入辅助数组
        while (pos2 <= high) {
            assist[index++] = array[pos2++];
        }

        //辅助数组元素复制进原数组
        for (int i = low; i <= high; i++) {
            array[i] = assist[i];
        }
    }
}
