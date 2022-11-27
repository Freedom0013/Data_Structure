package com.freedom.datastructure.test;

import com.freedom.datastructure.tree.IndexMaxPriorityQueue;
import com.freedom.datastructure.tree.IndexMinPriorityQueue;

/**
 * 索引优先队列测试
 * @author Freedom0013 @Date 2022-11-27
 * @version V1.00
 */
public class IndexPriorityQueueTest {
    public static void main(String[] args) {
        IndexMinPriorityQueue<String> indexMinPriorityQueue = new IndexMinPriorityQueue<>(10);
        indexMinPriorityQueue.insert(0, "A");
        indexMinPriorityQueue.insert(1, "C");
        indexMinPriorityQueue.insert(2, "H");
        indexMinPriorityQueue.insert(3, "F");
        indexMinPriorityQueue.insert(4, "E");
        indexMinPriorityQueue.insert(5, "D");
        indexMinPriorityQueue.changeItem(2, "B");
        while (!indexMinPriorityQueue.isEmpty()) {
            int min = indexMinPriorityQueue.getMinIndex();
            System.out.print("value = " + indexMinPriorityQueue.getItem(min) + " ");
            int minIndex = indexMinPriorityQueue.deleteMin();
            System.out.println("index = " + minIndex);
        }

        IndexMaxPriorityQueue<String> indexMaxPriorityQueue = new IndexMaxPriorityQueue<>(10);
        indexMaxPriorityQueue.insert(0, "A");
        indexMaxPriorityQueue.insert(1, "C");
        indexMaxPriorityQueue.insert(2, "H");
        indexMaxPriorityQueue.insert(3, "F");
        indexMaxPriorityQueue.insert(4, "E");
        indexMaxPriorityQueue.insert(5, "D");
        indexMaxPriorityQueue.changeItem(2, "B");
        while (!indexMaxPriorityQueue.isEmpty()) {
            int max = indexMaxPriorityQueue.getMaxIndex();
            System.out.print("value = " + indexMaxPriorityQueue.getItem(max) + " ");
            int maxIndex = indexMaxPriorityQueue.deleteMin();
            System.out.println("index = " + maxIndex);
        }
    }
}
