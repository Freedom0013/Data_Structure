package com.freedom.datastructure.linear;

import java.util.Iterator;

/**
 * 单链表存储结构
 * @Author Freedom0013 @Date 2022-11-17
 * @Version V1.00
 */
public class LinkList<T> implements Iterable<T>{
    /** 链表头结点(没有元素内容，但拥有指向第一个节点的指针) */
    private Node head;
    /** 链表长度 */
    private int size;

    public LinkList(){
        this.head = new Node(null,null);
        this.size = 0;
    }

    public void clear() {
        this.head.next = null;
        this.size = 0;
    }

    public int length() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 获取单链表在index位置的元素值
     * @param index 索引
     * @Return T 元素值
     */
    public T get(int index) {
        if (index < 0) {
            return null;
        }
        Node current = this.head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (T) current.item;
    }

    /**
     * 获取元素t位置
     * @param t 待查询元素
     */
    public int indexOf(T t) {
        Node current = this.head;
        for (int i = 0; current.next != null; i++) {
            current = current.next;
            if (current.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 在单链表末尾插入元素
     * @param t 待插入元素
     */
    public void insert(T t) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        Node newNode = new Node(t, null);
        current.next = newNode;
        this.size++;
    }

    /**
     * 在指定位置插入元素
     * @param index 待插入位置
     * @param t 插入蒜素
     */
    public void insert(int index, T t) {
        Node preNode = head;
        for (int i = 0; i <= index - 1; i++) {
            preNode = preNode.next;     //循环index-1次找到插入点的前一个位置
        }
        Node current = preNode.next;    //获取插入点的下一个节点
        Node newNode = new Node(t, current);    //创建新元素使它next指针指向下一个节点位置
        preNode.next = newNode;         //上一个节点指向新创建的节点完成插入
        this.size++;
    }

    /**
     * 删除指定位置元素
     * @param index 指定位置
     * @Return T 已删除的值
     */
    public T remove(int index) {
        Node preNode = head;
        for (int i = 0; i <= index - 1; i++) {
            preNode = preNode.next;     //循环index-1次找到删除点的前一个元素位置
        }
        Node currNode = preNode.next;
        Node currNext = currNode.next;
        preNode.next = currNext;
        return (T) currNode.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkListIterator();
    }

    /** 单链表遍历迭代器 */
    private class LinkListIterator implements Iterator<T> {
        private Node current;

        public LinkListIterator() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            current = current.next;     //指针向下移动一位指向第一个元素
            return (T) current.item;
        }
    }

    /** 链表节点类 */
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
