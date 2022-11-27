package com.freedom.datastructure.test;

import com.freedom.algorithm.sort.HeapSort;
import com.freedom.common.Tools;
import com.freedom.datastructure.tree.heap.Heap;
import com.freedom.datastructure.tree.heap.MaxPriorityQueue;
import com.freedom.datastructure.tree.heap.MinPriorityQueue;

/**
 * 堆测试
 * @author Freedom0013 @Date 2022-11-21
 * @version V1.00
 */
public class HeapTest {
    public static void main(String[] args) {
        Heap<String> minPriorityQueue = new MinPriorityQueue<>(10);
        minPriorityQueue.insert("G");
        minPriorityQueue.insert("F");
        minPriorityQueue.insert("E");
        minPriorityQueue.insert("D");
        minPriorityQueue.insert("C");
        minPriorityQueue.insert("B");
        minPriorityQueue.insert("A");

        Heap<String> maxPriorityQueue = new MaxPriorityQueue<>(10);
        maxPriorityQueue.insert("A");
        maxPriorityQueue.insert("B");
        maxPriorityQueue.insert("C");
        maxPriorityQueue.insert("D");
        maxPriorityQueue.insert("E");
        maxPriorityQueue.insert("F");
        maxPriorityQueue.insert("G");

        String res = null;
        while ((res = minPriorityQueue.delete()) != null) {
            System.out.print(res+ " ");
        }

        System.out.println();
        String res1 = null;
        while ((res1 = maxPriorityQueue.delete()) != null) {
            System.out.print(res1+ " ");
        }

        System.out.println();
        //堆排序
        String[] arr = {"S","O","R","T","E","X","A","M","P","L","F"};
        HeapSort.heapSort(arr);
        Tools.displayArrays(arr);
    }
}
