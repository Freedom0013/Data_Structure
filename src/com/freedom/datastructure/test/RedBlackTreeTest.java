package com.freedom.datastructure.test;

import com.freedom.datastructure.tree.RedBlackTree;

/**
 * 红黑树测试
 * @author Freedom0013 @Date 2022-11-27
 * @version V1.00
 */
public class RedBlackTreeTest {
    public static void main(String[] args) {
        RedBlackTree<String,String> redBlackTree = new RedBlackTree<>();
        redBlackTree.put("1","小明");
        redBlackTree.put("2","小王");
        redBlackTree.put("3","小兰");

        System.out.println(redBlackTree.get("1"));
        System.out.println(redBlackTree.get("2"));
        System.out.println(redBlackTree.get("3"));
    }
}
