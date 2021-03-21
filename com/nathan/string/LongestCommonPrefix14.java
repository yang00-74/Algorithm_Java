package com.nathan.string;

public class LongestCommonPrefix14 {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""
     *
     * 分治法：字符串两两比较
     * */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        int mid = left + (right - left) / 2;
        String leftStr = longestCommonPrefix(strs, left, mid);
        String rightStr = longestCommonPrefix(strs, mid + 1, right);
        return commonPrefix(leftStr, rightStr);
    }

    public String commonPrefix(String leftStr, String rightStr) {
        int minLen = Math.min(leftStr.length(), rightStr.length());
        for (int i = 0; i < minLen; i ++) {
            if (leftStr.charAt(i) != rightStr.charAt(i)){
                return leftStr.substring(0, i);
            }
        }
        return leftStr.substring(0, minLen);
    }
}
