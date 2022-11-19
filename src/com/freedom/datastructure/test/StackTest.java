package com.freedom.datastructure.test;

import com.freedom.common.Tools;
import com.freedom.datastructure.linear.Stack;

/**
 * 栈测试类
 * @author Freedom0013 @date 2022-11-19
 * @version V1.00
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
        System.out.println("------------------------------------");
        String result = stack.pop();
        System.out.println("result = " + result);
        System.out.println("size = " + stack.size());

        System.out.println("---------判断字符串括号是否闭合---------");
        String str1 = "我是一个有括号（配合一个左括号）(我是英文括号)【中文中括号】[英文中括号]{英文大括号}";
        System.out.println("str1括号是否匹配："+ Tools.isMatch(str1));
        System.out.println("str2括号是否匹配："+ Tools.isMatchExpand(str1));


        String str2 = "我是一个有括号（配合一个左括号）(我是英文括号中文中括号】[英文中括号) {英文大括号】";
        System.out.println("str2括号是否匹配："+ Tools.isMatch(str2));
        System.out.println("str2括号是否匹配："+ Tools.isMatchExpand(str2));

        System.out.println("---------逆波兰式值计算---------");
        //计算3+(5-2)*4-15/2 = 7.5
        String[] note = {"3","5","2","-","4","*","+","15","2","/","-"};
        System.out.println("逆波兰式值计算："+ Tools.calculateReversePolish(note));
    }
}
