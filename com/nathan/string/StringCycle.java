package com.nathan.string;

/**
 * 判断回文字串
 * 另一种思路是使用栈将字符串分割为 char 入栈,依次出栈与原字符串比较即可
 */

public class StringCycle {
    public static void main(String[] args) {
        String s = "lkjljkl";
        char[] c = s.toCharArray();
        int len = c.length - 1;


        for (int start = 0, end1 = len; start <= len && end1 >= 0; start++, end1--) {
            if (c[start] != c[end1]) {
                System.out.println("不是回文");
                return;
            }
        }
        System.out.println("是回文");
    }
}
