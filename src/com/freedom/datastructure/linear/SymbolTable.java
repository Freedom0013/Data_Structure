package com.freedom.datastructure.linear;

/**
 * 符号表（键值对存储）
 * @author Freedom0013 @Date 2022-11-19
 * @version V1.00
 */
public class SymbolTable<Key,Value>{
    /** 符号表头结点 */
    private Node head;
    /** 符号表大小 */
    private int size;

    public SymbolTable(){
        head = new Node(null,null,null);
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * 符号表插入
     * @param key 节点key
     * @param value 节点value
     */
    public void put(Key key, Value value) {
        Node node = head;
        while (node.next != null) { //遍历符号表如果找到key重复则意味着节点重复，直接替换value即可
            node = node.next;
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        //如符号表中无相同Key值，则创建新的结点添加在符号表末尾
        Node newNode = new Node(key, value, null);
        Node oldNode = head.next;
        newNode.next = oldNode;
        head.next = newNode;
        size++;
    }

    /**
     * 删除元素
     * @param key 待删除元素Key
     */
    public Value delete(Key key) {
        if (isEmpty()) {
            return null;
        }
        Node node = head;
        while (node.next != null) {     //遍历符号表找到与key相等的结点，让key之前的结点直接指向后一个结点，完成删除
            if (node.next.key.equals(key)) {
                Node current = node.next;
                node.next = node.next.next;
                size--;
                return (Value) current.value;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * 获取指定位置元素
     * @param key 元素Key
     * @return Value 元素值
     */
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        Node node = head;
        while (node.next != null) {
            node = node.next;
            if (node.key.equals(key)) {
                return (Value) node.value;
            }
        }
        return null;
    }

    /** 符号表结点类 */
    private class Node<T> {
        public Key key;
        public Value value;
        public SymbolTable.Node next;

        private Node() {
        }

        public Node(Key key, Value value, SymbolTable.Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
