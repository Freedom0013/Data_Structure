package com.freedom.algorithm.sort;

import com.freedom.common.Tools;

/**
 * 希尔排序
 * @author Freedom0013 @date 2022-11-15
 * @version V1.00
 */
public class Shell {
    /**
     * 希尔排序（缩小增量排序）
     * 选定一个增长量h，按h为数组分组（h一般为）,为每一组数据执行插入排序，完成一组h--最小减到1为止。不稳定排序，时间复杂度：O(n^1.3)
     * @param array 待排数组
     * @param isDesc 是否倒序
     * @return java.lang.Comparable<T>[] 已排序数组
     */
    public static <T> Comparable<T>[] shellSort(Comparable<T>[] array, boolean isDesc) {
        if (array == null || array.length < 2) {
            return array;
        }
        //根据array长度获取增长量h的值
        int h = 1;
        while (h < array.length / 2) {
            h = 2 * h + 1;
        }
        while (h >= 1) {
            //找到待插入元素
            for (int i = h; i < array.length; i++) {
                //插入元素到有序数组内
                for (int j = i; j >= h; j -= h) {
                    //待插入元素a[j],比较a[j]/、a[j-h]
                    if (isDesc?Tools.greater(array[j], array[j - h]):Tools.greater(array[j - h], array[j])) {
                        Tools.exch(array, j - h, j);
                    } else {
                        break;
                    }
                }
            }
            h = h / 2;
        }
        return array;
    }
}
