package com.freedom.datastructure.test;

import com.freedom.datastructure.linear.SequenceList;

/**
 * 线性表测试类
 * @author Freedom0013 @date 2022-11-16
 * @version V1.00
 */
public class SequenceListTest {
    public static void main(String[] args) {
        SequenceList<String> list = new SequenceList<>();
        //测试添加
        list.insert("小猫");
        list.insert("小狗");
        list.insert("小鱼");
        //测试插入
        list.insert(1, "小鸭");
        //测试获取元素索引
        System.out.println("小鸭index值：" + list.indexOf("小鸭"));
        System.out.println("小雅index值：" + list.indexOf("小雅"));
        //遍历
        for (int i = 0; i < list.length(); i++) {
            System.out.println("list[" + i + "] = " + list.get(i));
        }
        //foreach遍历
        for (String s : list) {
            System.out.println(s + "/");
        }
        //获取指定元素
        String result = list.get(1);
        System.out.println("result:" + result);
        //删除元素
        String remove = list.remove(0);
        System.out.println("remove:" + remove);
        for (String s : list) {
            System.out.println(s + "/");
        }
        //清空
        list.clear();
        System.out.println("清空后长度:" + list.length());
    }
}
