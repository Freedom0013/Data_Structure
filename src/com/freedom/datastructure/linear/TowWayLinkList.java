package com.freedom.datastructure.linear;

import java.util.Iterator;

/**
 * 双向链表
 * @author Freedom0013 @date 2022-11-18
 * @version V1.00
 */
public class TowWayLinkList<T> implements Iterable<T>{
    /** 链表首结点 */
    private TowWayLinkList.Node head;
    /** 链表尾结点 */
    private TowWayLinkList.Node last;
    /** 链表长度 */
    private int size;

    public TowWayLinkList() {
        this.head = new Node(null, null, null);
        this.last = null;
        this.size = 0;
    }

    public void clear() {
        this.head.next = null;
        this.head.pre = null;
        this.head.item = null;
        this.last = null;
        this.size = 0;
    }

    public int length() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public <T> T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return (T) head.next.item;
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return (T) last.item;
    }

    /**
     * 在双链表末尾插入元素
     * @param t 待插入元素
     */
    public void insert(T t) {
        if (isEmpty()) {
            Node newNode = new Node(head, t, null);
            this.last = newNode;
            this.head.next = newNode;
        } else {
            Node oldLast = this.last;
            Node newNode = new Node(oldLast, t, null);
            oldLast.next = newNode;
            this.last = newNode;
        }
        this.size++;
    }

    /**
     * 在指定位置插入元素
     * @param index 待插入位置
     * @param t 插入元素
     */
    public void insert(int index, T t) {
        if (index > size) {
            return;
        }
        Node pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node curr = pre.next;
        Node newNode = new Node(pre, t, curr);
        pre.next = newNode;
        curr.pre = newNode;
        size++;
    }

    /**
     * 获取双链表在index位置的元素值
     * @param index 索引
     * @return 元素值
     */
    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        Node n = head.next;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return (T) n.item;
    }

    /**
     * 获取元素t位置
     * @param t 待查询元素
     * @return 元素值
     */
    public int indexOf(T t) {
        if (isEmpty()) {
            return -1;
        }
        Node node = head;
        for (int i = 0; node.next != null; i++) {
            node = node.next;
            if (node.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除指定位置元素
     * @param index 指定位置
     * @return T 已删除的值
     */
    public T remove(int index) {
        if (isEmpty()) {
            return null;
        }
        Node pre = head;
        for (int i = 0; i < index; i++) {//从头结点开始遍历，直到找到要删除的前一个元素停下，否则向后移动指针
            pre = pre.next;
        }
        Node curr = pre.next;   //拿到当前节点和当前节点的下一个节点，后将前一个节点的指针域直接指向下一个节点，完成删除
        Node nextNode = curr.next;
        pre.next = nextNode;
        nextNode.pre = pre;
        size--;
        return (T) curr.item;
    }

    @Override
    public Iterator iterator() {
        return new TowWayLinkListIterator();
    }

    /** 双链表迭代器 */
    private class TowWayLinkListIterator implements Iterator<T> {
        private Node node;

        public TowWayLinkListIterator() {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public T next() {
            node = node.next;
            return (T) node.item;
        }
    }

    /** 双链表节点类(一个数据域，两个指针域) */
    private class Node<T> {
        /** 上一个元素指针 */
        public TowWayLinkList.Node pre;
        /** 当前数据元素 */
        public T item;
        /** 下一个元素指针 */
        public TowWayLinkList.Node next;

        private Node() {}

        public Node(TowWayLinkList.Node pre, T item, TowWayLinkList.Node next) {
            this.pre = pre;
            this.item = item;
            this.next = next;
        }
    }
}
