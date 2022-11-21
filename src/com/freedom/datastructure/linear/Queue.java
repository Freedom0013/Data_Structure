package com.freedom.datastructure.linear;

import java.util.Iterator;

/**
 * 队列
 * @author Freedom0013 @Date 2022-11-19
 * @version V1.00
 */
public class Queue<T> implements Iterable<T> {
    /** 队列头结点 */
    private Node head;
    /** 队列大小 */
    private int size;
    /** 队列尾结点 */
    private Node last;

    public Queue() {
        this.head = new Node(null, null);
        this.last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * 入队T
     * @param t 待入队元素
     */
    public void enqueue(T t) {
        if (last == null) {
            last = new Node(t, null);
            head.next = last;
        } else {
            Node oldlast = last;
            last = new Node(t, null);
            oldlast.next = last;
        }
        size++;
    }

    /**
     * 出队
     * @return T 出队元素
     */
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node oldFirst = head.next;
        head.next = oldFirst.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return (T) oldFirst.item;
    }


    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    /** 队列遍历迭代器 */
    private class QueueIterator implements Iterator<T> {
        private Node current;

        public QueueIterator() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            current = current.next;
            return (T) current.item;
        }
    }

    /** 队列结点类 */
    private class Node<T> {
        /** 当前数据元素 */
        public T item;
        /** 下一个元素指针 */
        public Node next;
        private Node() {}
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
