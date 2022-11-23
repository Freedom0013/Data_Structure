package com.freedom.datastructure.test;

import com.freedom.algorithm.sort.HeapSort;
import com.freedom.common.Tools;
import com.freedom.datastructure.tree.Heap;

/**
 * @author Freedom0013 @Date 2022-11-21
 * @version V1.00
 */
public class HeapTest {
    public static void main(String[] args) {
//        Heap<String> heap = new Heap<>(10);
//        heap.insert("A");
//        heap.insert("B");
//        heap.insert("C");
//        heap.insert("D");
//        heap.insert("E");
//        heap.insert("F");
//        heap.insert("G");
//
//        String res = null;
//        while ((res = heap.deleteMax()) != null) {
//            System.out.println(res);
//        }

        String[] arr = {"S","O","R","T","E","X","A","M","P","L","E"};
        HeapSort.heapSort(arr,false);
        Tools.displayArrays(arr);

    }
}
