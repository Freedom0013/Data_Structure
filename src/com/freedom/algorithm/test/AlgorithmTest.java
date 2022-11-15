package com.freedom.algorithm.test;

import com.freedom.algorithm.sort.Bubble;
import com.freedom.algorithm.sort.Selection;
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
//        Tools.displayArrays(Bubble.bubbleSort(arrays, true));

        System.out.println("选择排序后：");
        Tools.displayArrays(Selection.SelectionSort(arrays, true));
    }
}
