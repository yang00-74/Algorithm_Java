package com.nathan.string.kmp;

public class StrStr28 {

    /**
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
     * 如果不存在，则返回  -1
     *
     * */
    public int strStr(String haystack, String target) {
        if (target.length() == 0) {
            return 0;
        }
        int[] next = getNextTable(target);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != target.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == target.charAt(j + 1)) {
                j++;
            }
            if (j == target.length() - 1) {
                return i - target.length() + 1;
            }
        }
        return -1;
    }

    public int[] getNextTable(String target) {
        char[] chars = target.toCharArray();

        int j = -1;
        int[] next = new int[target.length()];
        next[0] = j;

        // i 为后缀的末尾，j 表示前缀的末尾
        // 模式串：aabaaf
        for (int i = 1; i < target.length(); i++) {
            // 当 i = 1 时，前缀为a, 后缀为 abaaf, 有相同前后缀a
            // 当 i = 2 时，前缀为 aa, 后缀为 baaf，无相同前后缀
            // 当 i = 3 时，前缀为 aab，后缀为 aaf，有相同前后缀 aa
            while (j > 0 && chars[i] != chars[j + 1]) {
                // 前后缀不相同需向前回溯，将前缀末尾往左移动
                j = next[j];
            }
            // 前后缀相同, 前缀末尾自增 1，向右移动
            if (chars[i] == chars[j + 1]) {
                j++;
            }
            // 将相同前缀的长度 j 赋给 next[i]
            next[i] = j;
        }
        return next;
    }
}
