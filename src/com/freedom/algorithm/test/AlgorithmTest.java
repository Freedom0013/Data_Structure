package com.freedom.algorithm.test;

import com.freedom.algorithm.sort.*;
import com.freedom.common.Tools;

/**
 * 排序测试类
 * @Author Freedom0013 @Date 2022-11-15
 * @Version V1.00
 */
public class AlgorithmTest {
    public static void main(String[] args) {
        Integer[] arrays = {5, 8, 4, 7, 3, 1, 9, 2, 0, 6};
        System.out.println("排序前：");
        Tools.displayArrays(arrays);

//        System.out.println("倒序冒泡排序后：");
//        Tools.displayArrays(Bubble.bubbleSort(arrays, false));
//        System.out.println("选择排序后：");
//        Tools.displayArrays(Selection.selectionSort(arrays, false));
//        System.out.println("插入排序后：");
//        Tools.displayArrays(Insertion.insertionSort(arrays, false));
//        System.out.println("希尔排序后：");
//        Tools.displayArrays(Shell.shellSort(arrays, false));

        System.out.println("归并排序后：");
        Merge.mergeSort(arrays, false);
        Tools.displayArrays(arrays);

//        System.out.println("快速排序后：");
//        Tools.displayArrays(Shell.ShellSort(arrays, false));
//        System.out.println("堆排序后：");
//        Tools.displayArrays(Shell.ShellSort(arrays, false));

    }
}
