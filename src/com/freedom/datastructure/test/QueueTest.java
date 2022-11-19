package com.freedom.datastructure.test;

import com.freedom.datastructure.linear.Queue;

/**
 * 队列测试类
 * @author Freedom0013 @Date 2022-11-19
 * @version V1.00
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        for (String s : queue) {
            System.out.println("s = " + s);
        }

        String res = queue.dequeue();
        System.out.println("出队元素为：" + res);
        System.out.println("剩余元素个数：" + queue.size());
    }
}
