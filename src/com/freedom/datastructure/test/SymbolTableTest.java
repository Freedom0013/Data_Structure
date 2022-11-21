package com.freedom.datastructure.test;

import com.freedom.datastructure.symbol.OrderSymbolTable;
import com.freedom.datastructure.symbol.SymbolTable;

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
        for (Integer integer : symbolTable) {
            System.out.println("Key = " + integer + ",Value = " + symbolTable.get(integer));
        }
        System.out.println("符号表大小：" + symbolTable.size());
        symbolTable.put(2, "hhha");
        System.out.println("替换后的key = 2元素：" + symbolTable.get(2));

        System.out.println("删除二号元素：" + symbolTable.delete(2));
        System.out.println("删除后符号表大小：" + symbolTable.size());
        for (Integer integer : symbolTable) {
            System.out.println("Key = " + integer + ",Value = " + symbolTable.get(integer));
        }
        System.out.println("--------------------------------");
        OrderSymbolTable<Integer, String> ordersymboltable = new OrderSymbolTable<>();
        ordersymboltable.put(1, "大明");
        ordersymboltable.put(2, "大红");
        ordersymboltable.put(4, "大白");
        ordersymboltable.put(7, "大蓝");
        ordersymboltable.put(3, "大紫");
        for (Integer integer : ordersymboltable) {
            System.out.println("Key = " + integer + ",Value = " + ordersymboltable.get(integer));
        }
        System.out.println("----");
    }
}
