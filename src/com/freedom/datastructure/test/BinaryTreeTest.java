package com.freedom.datastructure.test;

import com.freedom.datastructure.linear.Queue;
import com.freedom.datastructure.tree.BinaryTree;

/**
 * 二叉查找树测试
 * @author Freedom0013 @Date 2022-11-21
 * @version V1.00
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<String, String> binaryTree = new BinaryTree<>();
        binaryTree.put("E", "5");
        binaryTree.put("B", "2");
        binaryTree.put("G", "7");
        binaryTree.put("A", "1");
        binaryTree.put("D", "4");
        binaryTree.put("F", "6");
        binaryTree.put("H", "8");
        binaryTree.put("C", "3");

        System.out.println(binaryTree.getMin());
        System.out.println(binaryTree.getMax());


        System.out.println(binaryTree.size());
        System.out.println(binaryTree.get("E"));

        binaryTree.delete("D");
        System.out.println(binaryTree.size());
        System.out.println(binaryTree.get("E"));

        System.out.println("----前序遍历----");
        Queue<String> keys1 = binaryTree.preErgodic();
        for (String key : keys1) {
            System.out.println("Key = " + key);
        }
        System.out.println("----中序遍历----");
        Queue<String> keys2 = binaryTree.minErgodic();
        for (String key : keys2) {
            System.out.println("Key = " + key);
        }
        System.out.println("----后序遍历----");
        Queue<String> keys3 = binaryTree.afterErgodic();
        for (String key : keys3) {
            System.out.println("Key = " + key);
        }
        System.out.println("----层序遍历----");
        Queue<String> keys4 = binaryTree.layerErgodic();
        for (String key : keys4) {
            System.out.println("Key = " + key);
        }

        System.out.println("最大深度：" + binaryTree.getMaxDepth());

    }
}
