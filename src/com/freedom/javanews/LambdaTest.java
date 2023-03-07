package com.freedom.javanews;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @author Freedom0013 @Date 2022-12-8
 * @version V1.00
 */
public class LambdaTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("小DDDD");
        arrayList.add("小BB");
        arrayList.add("小A");
        arrayList.add("小CCC");

//        //此实现等价于下方函数式编程语句
//        arrayList.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });
//        for (String s : arrayList) {
//            System.out.println(s);
//        }

        //函数式编程语句stream
        arrayList.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
    }
}
