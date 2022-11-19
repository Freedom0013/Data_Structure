package com.freedom.datastructure.test;

import com.freedom.datastructure.linear.Stack;

/**
 * @Author Freedom0013 @Date 2022-11-19
 * @Version V1.00
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        for (String s : stack) {
            System.out.println("s = " +s);
        }
        System.out.println("----------------");
        String result = stack.pop();
        System.out.println("result = " + result);
        System.out.println("size = " + stack.size());
    }
}
