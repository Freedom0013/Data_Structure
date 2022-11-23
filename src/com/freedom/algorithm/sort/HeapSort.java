package com.freedom.algorithm.sort;

/**
 * 堆排序
 * @author Freedom0013 @Date 2022-11-15
 * @version V1.00
 */
public class HeapSort {
    /** 比较1是否小于j */
    private static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    /**
     * 交换元素
     */
    private static void exch(Comparable[] heap, int i, int j) {
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * 构建有序堆
     * @param source 元素组
     * @param heap 构建完成堆数组
     */
    private static void createHeap(Comparable[] source, Comparable[] heap) {
        //把原数组当中的元素复制进堆，并且对堆中元素进行下沉调整（长度从一半处即树干开始，向索引1处进行扫描）从而使堆有序
        System.arraycopy(source, 0, heap, 1, source.length);
        for (int i = (heap.length) / 2; i > 0; i++) {
            sink(heap, i, heap.length - 1);
        }
    }

    /**
     * 对堆中元素进行下沉操作
     * @param heap 原始堆
     * @param target 要下沉元素索引
     * @param range 范围0~range
     */
    private static void sink(Comparable[] heap, int target, int range) {
        //通过循环不断对比当前k节点和其左子节点2k及右子节点2k+1处的较大值元素，如果当前节点小，则互换位置
        while (2 * target <= range) {
            int max;//记录较大节点所在的索引
            if (2 * target + 1 <= range) {
                if (less(heap,2 * target, 2 * target + 1)) {
                    max = 2 * target + 1;
                } else {
                    max = 2 * target;
                }
            } else {
                max = 2 * target;
            }
            //比较当前节点和较大值
            if (!less(heap,target, max)) {
                break;
            }
            exch(heap,target, max);
            target = max;
        }

//        while (2 * target <= range) {
//            int max;//找出当前节点的较大子节点
//            if (2 * target + 1 <= range) {
//                if (less(heap, 2 * target, 2 * target + 1)) {
//                    max = 2 * target + 1;
//                } else {
//                    max = 2 * target;
//                }
//            } else {
//                max = 2 * target;
//            }
//            //比较当前节点和较大叶子结点
//            if (!less(heap, target, max)) {
//                break;
//            }
//            exch(heap, target, max);
//            target = max;
//        }
    }

    /**
     * 堆排序
     * @param array 待排数组
     * @param isDesc 是否倒序
     * @return java.lang.Comparable<T>[] 已排序数组
     */
    public static <T> void heapSort(Comparable<T>[] array, boolean isDesc) {
        if (array == null || array.length < 2) {
            return;
        }
        Comparable[] heap = new Comparable[array.length + 1];
        createHeap(array, heap);
        int size = heap.length - 1;
        while (size != 1) {
            exch(heap, 1, size);
            size--;
            sink(heap, 1, size);
        }
        System.arraycopy(heap, 1, array, 0, array.length);
    }
}
