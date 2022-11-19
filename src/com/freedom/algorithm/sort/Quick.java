package com.freedom.algorithm.sort;

import com.freedom.common.Tools;

/**
 * 快速排序
 * @author Freedom0013 @date 2022-11-15
 * @version V1.00
 */
public class Quick {
    /**
     * 快速排序
     * 设定一个分界值将数组一分为二，将大于分界值的数放在右边，小于分界值放在左边，放完后分别对左右子组进行排序，循环结束后数组有序（不必合并数组，不必使用辅助数组）
     * 不稳定排序，时间复杂度：最优：O(nlogN)，最坏：O(N^2)，平均O(nlogN)
     * @param array 待排数组
     * @param isDesc 是否倒序
     * @return java.lang.Comparable<T>[] 已排序数组
     */
    public static <T> Comparable<T>[] quickSort(Comparable<T>[] array, boolean isDesc) {
        if (array == null) {
            return null;
        }
        int low = 0;
        int high = array.length - 1;
        return quickSort(array, low, high, isDesc);
    }

    /**
     * 对数组中从low到high索引进行排序
     * @param array 待排数组
     * @param low 索引下限
     * @param high 索引上限
     * @param isDesc 是否倒序
     * @return java.lang.Comparable<T>[] 已排序数组
     */
    private static <T> Comparable<T>[] quickSort(Comparable<T>[] array, int low, int high, boolean isDesc) {
        if (high <= low) {//安全值校验
            return array;
        }
        int partition = partition(array, low, high, isDesc);//对目标数组进行左右分组，并拿到界限索引值
        quickSort(array, low, partition - 1, isDesc);//左子组有序
        quickSort(array, partition + 1, high, isDesc);//右子组有序
        return array;
    }

    /**
     * 对数组中从low到high处元素进行分组，并返回分组界限对应索引
     * @param array 待排数组
     * @param low 索引下限
     * @param high 索引上限
     * @param isDesc 是否倒序
     * @return int 分组界限对应索引
     */
    private static <T> int partition(Comparable<T>[] array, int low, int high, boolean isDesc) {
        //确定分界值,第一个分界值应该为数组第一个元素，随后以第一个元素为基准，在正序排序时，左指针找比分界打的元素，
        Comparable<T> key = array[low];
        //使用两个指针，分别指向待切元素的最小索引和最大索引的的下一个位置
        int left = low;
        int right = high + 1;

        while (true) {//切分(左右指针相对而行进行循环)
            while (isDesc ? Tools.greater(key, array[--right]) : Tools.greater(array[--right], key)) {//从右向左扫描，移动right，得到一个比分界值小的元素停止
                if (right == low) {
                    break;
                }
            }
            while (isDesc ? Tools.greater(array[++left], key) : Tools.greater(key, array[++left])) {//从左向右扫描，移动left，得到一个比分界值大的元素停止
                if (left == high) {
                    break;
                }
            }
            if (left >= right) {//判断左右指针位置，如果左边大于右边，则元素扫描完毕，循环结束，如果不是，交换元素继续扫描
                break;
            } else {
                Tools.exch(array, left, right);
            }
        }

        Tools.exch(array, low, right);//交换分界值
        return right;
    }
}
