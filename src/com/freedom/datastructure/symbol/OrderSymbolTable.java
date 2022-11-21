package com.freedom.datastructure.symbol;

/**
 * 有序符号表（键值对存储）
 * @author Freedom0013 @Date 2022-11-19
 * @version V1.00
 */
public class OrderSymbolTable<Key extends Comparable<Key>, Value> extends SymbolTable<Key, Value> {
    public OrderSymbolTable() {
        super();
    }

    /**
     * 有序符号表插入
     * @param key   节点key
     * @param value 节点value
     */
    public void put(Key key, Value value) {
        if (key == null) {
            return;
        }
        Node current = head.next;
        Node pre = head;
        //如果待插入key值大于当前元素，两个指针向后移动
        while (current != null && key.compareTo(current.key) > 0) {
            pre = current;
            current = current.next;
        }
        //找到插入点，完成插入值替换
        if (current != null && key.compareTo(current.key) == 0) {
            current.value = value;
            return;
        }
        //如果当前节点键和key不一样，则放在current之前
        Node newNode = new Node(key, value, current);
        pre.next = newNode;
        size++;
    }
}
