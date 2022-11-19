package com.freedom.datastructure.linear;

import java.util.Iterator;

/**
 * 单链表存储结构
 * @author Freedom0013 @date 2022-11-17
 * @version V1.00
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
     * @return T 元素值
     */
    public T get(int index) {
        if (index < 0 || isEmpty()) {
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
        if (isEmpty()) {
            return -1;
        }
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
     * @param t 插入元素
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
     * @return T 已删除的值
     */
    public T remove(int index) {
        if(isEmpty()){
            return null;
        }
        Node preNode = head;
        for (int i = 0; i <= index - 1; i++) {
            preNode = preNode.next;     //循环index-1次找到删除点的前一个元素位置
        }
        Node currNode = preNode.next;
        Node currNext = currNode.next;
        preNode.next = currNext;
        return (T) currNode.item;
    }

    /** 反转单链表 */
    public void reverse() {
        if (isEmpty()) {
            return;
        }
        reverse(head.next);
    }

    /** 从node节点开始反转单链表 */
    public Node reverse(Node current) {
        if (current.next == null) { //找到原先尾元素，并使之成为新的头元素，并返回它本身
            head.next = current;
            return current;
        }
        //如果未找到尾元素，则把当前元素的下一个元素扔进递归调用，
        //等待递归返回找到的尾元素后，拿尾元素next指针只指向自己并吧自己的next指针置为空后返回上层递归，直到返回头结点反转完成。
        Node pre = reverse(current.next);
        pre.next = current;
        current.next = null;
        return current;
    }

    /** 快慢指针获取中间值 */
    public T getMid() {
        if (isEmpty()){
            return null;
        }
        //定义两个指针，起点都在头结点，快指针速度是慢指针一倍，快指针遍历到表尾时，由于速度差，满指针刚好在中间位置，完成查找返回
        Node fast = head.next;
        Node slow = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return (T) slow.item;
    }

    /**
     * 判断单链表中链接是否有环
     */
    public boolean isCircl() {
        if (isEmpty()) {
            return false;
        }
        //依旧定义快慢指针，遍历链表，如快指针能追上满指针，则代表链表有环，如果遍历到末尾仍然未追上，则链表无环
        Node fast = head.next;
        Node slow = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取单链表环起点
     */
    public T getCirclEnter() {
        if (isEmpty()) {
            return null;
        }
        //定义三个指针，使用快慢指针找到环入口后，快慢指针继续循环并加入temp指针，temp指针每次向后移动一个元素，直到与满指针相遇则找到环入口
        Node fast = head.next;
        Node slow = head.next;
        Node temp = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {    //找到环入口，创建temp从头结点开始执行
                temp = head.next;
                continue;
            }
            if (temp != null) {
                temp = temp.next;
                if (temp.equals(slow)) {
                    break;
                }
            }
        }
        return (T) temp;
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
