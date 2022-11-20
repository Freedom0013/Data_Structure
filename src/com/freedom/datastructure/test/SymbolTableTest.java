package com.freedom.datastructure.test;

import com.freedom.datastructure.linear.SymbolTable;

/**
 * 符号表测试类
 * @author Freedom0013 @Date 2022-11-20
 * @version V1.00
 */
public class SymbolTableTest {
    public static void main(String[] args) {
        SymbolTable<Integer, String> symbolTable = new SymbolTable<>();
        symbolTable.put(1, "小明");
        symbolTable.put(3, "小红");
        symbolTable.put(2, "小蓝");

        System.out.println("符号表大小："+symbolTable.size());
        symbolTable.put(2, "hhha");
        System.out.println("替换后的key = 2元素：" + symbolTable.get(2));

        System.out.println("删除二号元素：" + symbolTable.delete(2));
        System.out.println("删除后符号表大小：" + symbolTable.size());
    }
}
