package com.freedom.datastructure.test;

import com.freedom.datastructure.tree.IndexMinPriorityQueue;

/**
 * 索引优先队列测试
 * @author Freedom0013 @Date 2022-11-27
 * @version V1.00
 */
public class IndexPriorityQueueTest {
    public static void main(String[] args) {
        IndexMinPriorityQueue<String> indexMinPriorityQueue = new IndexMinPriorityQueue<>(10);
        indexMinPriorityQueue.insert(0,"A");
        indexMinPriorityQueue.insert(1,"C");
        indexMinPriorityQueue.insert(2,"F");

        indexMinPriorityQueue.changeItem(2,"B");

        while (!indexMinPriorityQueue.isEmpty()){
            int i = indexMinPriorityQueue.deleteMin();
            System.out.print("index:"+ i+" ");
        }
    }
}
