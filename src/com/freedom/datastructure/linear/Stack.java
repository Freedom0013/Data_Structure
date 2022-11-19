package com.freedom.datastructure.linear;

import java.util.Iterator;

/**
 * 栈实现
 * @Author Freedom0013 @Date 2022-11-19
 * @Version V1.00
 */
public class Stack<T> implements Iterable<T>{
    private Node head;
    private int size;


    public Stack(){
        this.head = new Node(null,null);
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * 压栈
     * @param t 栈结点内容
     */
    public void push(T t) {
        Node oldFirst = head.next;
        Node newNode = new Node(t, null);
        head.next = newNode;
        newNode.next = oldFirst;
        size++;
    }

    /** 弹栈 */
    public T pop() {
        Node oldfirst = head.next;
        if (oldfirst == null) {
            return null;
        }
        head.next = oldfirst.next;
        size--;
        return (T) oldfirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private Node current;

        public StackIterator() {
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

    /** 栈结点类 */
    private class Node<T> {
        /** 当前数据元素 */
        public T item;
        /** 下一个元素指针 */
        public Stack.Node next;
        private Node() {}
        public Node(T item, Stack.Node next) {
            this.item = item;
            this.next = next;
        }
    }


}
