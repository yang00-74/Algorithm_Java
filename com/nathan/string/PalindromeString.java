package com.nathan.string;

/**
 * 判断回文字串
 * 另一种思路是使用栈将字符串分割为 char 入栈,依次出栈与原字符串比较即可
 */

public class PalindromeString {
    public static void main(String[] args) {
        String s = "helloGod";
        if (palindrome(s)) {
            System.out.println("是回文");
        } else {
            System.out.println("不是回文");
        }
    }

    public static boolean palindrome(String s) {
        if (null == s || "".equals(s)) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right++)) {
                return false;
            }
        }
        return true;
    }
}
