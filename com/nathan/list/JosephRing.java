package com.nathan.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫环：已知n个人(以编号1，2，3...n分别表示)围坐在一张圆桌周围。
 * 从编号为k的人开始报数，数到m的那个人出列;他的下一个人又从1开始报数，
 * 数到m的那个人又出列;依此规律重复下去，直到圆桌周围的人全部出列。
 */
public class JosephRing {

    public static void main(String[] args) {
        //50个人，从第一个人开始数，数到3的人出列
        countThree(5, 4, 3);
    }

    /**
     * @param n     人的总数
     * @param start 开始报数的序号，start < n
     * @param m     出列的标记(可以大于n)
     */
    private static void countThree(int n, int start, int m) {

        List<Integer> list = new ArrayList<Integer>();

        //初始化列表
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        for (int j = 0; j < start - 1; j++) {
            // 调整list，使第一个报数的人 k 位于列表头部，否则 k 之前的人不会加入环中进行循环
            list.add(list.remove(0));
        }

        while (list.size() > 1) {
            //将前面不被淘汰的移入列表尾端
            for (int j = 0; j < m - 1; j++) {
                list.add(list.remove(0));
            }
            //打印出列序号
            //System.out.println(com.nathan.list.remove(start));
            list.remove(0);//淘汰的直接移除
        }
        //打印最后留下的序号
        System.out.println(list.get(0));
    }
}
