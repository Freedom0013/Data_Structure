package com.freedom.common;

import com.freedom.datastructure.linear.Stack;

/**
 * 工具类
 * @author Freedom0013 @date 2022-11-14
 * @version V1.00
 */
public class Tools {
    /**
     * 比较c1是否大于c2
     * @param c1 比较对象1
     * @param c2 比较对象2
     * @return boolean 比较结果
     */
    public static <T> boolean greater(Comparable<T> c1, Comparable<T> c2) {
        if (c1 == null || c2 == null) {
            return false;
        }
        return c1.compareTo((T) c2) > 0;
    }

    /**
     * 交换数组array中i、j索引对象位置
     * @param array 数组array
     * @param i 索引i
     * @param j 索引j
     */
    public static <T> void exch(Comparable<T>[] array, int i, int j) {
        if(array == null){
            return;
        }
        Comparable<T> temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 打印数组
     * @param arrays 需要显示的数组
     */
    public static <T> void displayArrays(T[] arrays) {
        if (arrays == null) {
            return;
        }
        System.out.print(arrays.getClass().getSimpleName() + ":[");
        for (int i = 0; i < arrays.length; i++) {
            if (i != arrays.length - 1) {
                System.out.print(arrays[i] + ",");
            } else {
                System.out.println(arrays[i] + "];");
            }
        }
    }

    /**
     * 判断字符串中左右括号是否匹配(仅限英文小括号)
     * @param str 被判断字符串
     * @return boolean 是否匹配
     */
    @Deprecated
    public static boolean isMatch(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Stack<String> stack = new Stack<>();        //使用栈来进行匹配判断
        for (int i = 0; i < str.length(); i++) {    //遍历字符串
            String curr = str.charAt(i) + "";
            //遇到右括号压栈，遇到左括号弹栈，如果左右括号匹配，一压一出栈应该清空，如最终栈不空代表左右括号不匹配
            switch (curr) {
                case "(":
                    stack.push(curr);
                    break;
                case ")":
                    String pop = stack.pop();
                    if (pop == null) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 判断字符串中左右括号是否匹配（可判断:中英文括号，中英文中括号，英文大括号）
     * @param str 被判断字符串
     * @return boolean 是否匹配
     */
    public static boolean isMatchExpand(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int brackets1 = 0;//英文括号
        int brackets2 = 0;//中文括号
        int brackets3 = 0;//英文中括号
        int brackets4 = 0;//中文中括号
        int brackets5 = 0;//英文大括号
        for (int i = 0; i < str.length(); i++) {    //遍历字符串
            String curr = str.charAt(i) + "";
            switch (curr) {
                case "(":
                    brackets1++;
                    break;
                case "（":
                    brackets2++;
                    break;
                case "[":
                    brackets3++;
                    break;
                case "【":
                    brackets4++;
                    break;
                case "{":
                    brackets5++;
                    break;
                case ")":
                    brackets1--;
                    break;
                case "）":
                    brackets2--;
                    break;
                case "]":
                    brackets3--;
                    break;
                case "】":
                    brackets4--;
                    break;
                case "}":
                    brackets5--;
                    break;
            }
        }
        return brackets1 == 0 && brackets2 == 0 && brackets3 == 0 && brackets4 == 0 && brackets5 == 0;
    }

    /**
     * 使用栈运算逆波兰表达式值
     * @param notice 逆波兰表达式
     * @return Double 计算结果值
     */
    public static Double calculateReversePolish(String[] notice) {
        if (notice == null || notice.length == 0) {
            return 0.0d;
        }
        Stack<Double> stack = new Stack<>();
        //遍历数组把找到的数压栈，找到运算符时弹栈最近的两个栈元素进行计算后结果再进栈继续计算，注意减法和出发弹栈后计算顺序
        for (int i = 0; i < notice.length; i++) {
            String current = notice[i];
            Double d1;
            Double d2;
            switch (current) {
                case "+":
                    d1 = stack.pop();
                    d2 = stack.pop();
                    stack.push(d1 + d2);
                    break;
                case "-":
                    d1 = stack.pop();
                    d2 = stack.pop();
                    stack.push(d2 - d1);
                    break;
                case "*":
                    d1 = stack.pop();
                    d2 = stack.pop();
                    stack.push(d1 * d2);
                    break;
                case "/":
                    d1 = stack.pop();
                    d2 = stack.pop();
                    stack.push(d2 / d1);
                    break;
                default:
                    stack.push(Double.parseDouble(current));
                    break;
            }
        }
        return stack.pop();
    }

}
