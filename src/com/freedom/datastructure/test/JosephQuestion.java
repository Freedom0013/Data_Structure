package com.freedom.datastructure.test;

/**
 * 循环链表解决约瑟夫问题
 * 约瑟夫问题：有41个人进行1-3报数，报到3的人退出游戏，请问最后剩余在场的最后两名玩家的标号是什么？
 * @author Freedom0013 @date 2022-11-18
 * @version V1.00
 */
public class JosephQuestion {
    public static void main(String[] args) {
        int length = 41;

        //构建循环链表
        Node<Integer> head = null;
        Node<Integer> pre = null;
        for (int i = 1; i <= length; i++) { //遍历产生41个节点
            if (i == 1) {
                head = new Node<>(i, null); //创建头结点，指针指向当前节点
                pre = head;
                continue;
            }
            Node<Integer> node = new Node<>(i, null);
            pre.next = node;    //为循环链表添加元素
            pre = node;
            if (i == length) {  //如果链表构建完毕，尾节点指向头节点完成循环链表构建
                pre.next = head;
            }
        }

        //定义计数器
        int count = 0;

        //遍历链表，
        Node<Integer> curr = head;
        Node<Integer> before = null;
        while (curr != curr.next) {
            count++;

            if (count == 3) {   //报数到3，从循环链表中删除当前节点，报数置0继续报数
                before.next = curr.next;
                System.out.print(curr.item + ",");
                curr = curr.next;
                count = 0;
            } else {
                before = curr;
                curr = curr.next;
            }
        }
        System.out.println(curr.item);//显示最终剩下在场上的最后一名玩家
    }

    private static class Node<T> {
        public T item;
        public JosephQuestion.Node next;
        private Node() {}
        public Node(T item, JosephQuestion.Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
