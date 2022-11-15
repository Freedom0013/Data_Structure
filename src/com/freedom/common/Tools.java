package com.freedom.common;

/**
 * 排序算法工具类
 * @author Freedom0013 @date 2022-11-14
 * @version V1.00
 */
public class Tools {
    /**
     * 比较c1是否大于c2
     * @param c1 比较对象1
     * @param c2 比较对象2
     * @Return boolean
     * @Author Freedom0013 @Date 2022-11-15
     */
    public static <T> boolean greater(Comparable<T> c1, Comparable<T> c2) {
        if (c1 == null || c2 == null) {
            return false;
        }
        return c1.compareTo((T) c2) > 0;
    }

    /**
     * 交换数组array中i、j索引对象位置
     * @param array 数组array
     * @param i 索引i
     * @param j 索引j
     * @Return void
     * @Author Freedom0013 @Date 2022-11-15
     */
    public static <T> void exch(Comparable<T>[] array, int i, int j) {
        if(array == null){
            return;
        }
        Comparable<T> temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 打印数组
     * @param arrays 需要显示的数组
     * @Return void
     * @Author Freedom0013 @Date 2022-11-15
     */
    public static <T> void displayArrays(T[] arrays) {
        if (arrays == null) {
            return;
        }
        System.out.print(arrays.getClass().getSimpleName() + ":[");
        for (int i = 0; i < arrays.length; i++) {
            if (i != arrays.length - 1) {
                System.out.print(arrays[i] + ",");
            } else {
                System.out.println(arrays[i] + "];");
            }
        }
    }
}
