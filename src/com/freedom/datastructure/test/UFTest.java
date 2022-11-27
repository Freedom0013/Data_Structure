package com.freedom.datastructure.test;

import com.freedom.datastructure.uf.UF;
import com.freedom.datastructure.uf.UFTree;

import java.util.Scanner;

/**
 * 并查集测试
 * @author Freedom0013 @Date 2022-11-27
 * @version V1.00
 */
public class UFTest {
    public static void main(String[] args) {
//        UF uf = new UF(5);
        UFTree uf = new UFTree(5);
        System.out.println("默认" + uf.getCount() + "分组");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input P:");
            int p = sc.nextInt();
            System.out.println("Input Q:");
            int q = sc.nextInt();

            if (uf.connected(p, q)) {
                System.out.println(p + "元素" + q + "元素已经在同一组");
                continue;
            }
            uf.union(p, q);
            System.out.println(uf.getCount() + "分组");
        }
    }
}
