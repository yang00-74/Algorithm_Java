package com.nathan.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Partition131 {

    /**
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     *
     * 返回 s 所有可能的分割方案
     * */
    private List<List<String>> res = new ArrayList<>();
    private List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return res;
    }

    public void backTracking(String s, int startIndex) {

        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (!isPalindrome(s, startIndex, i)) {
                continue;
            }
            path.add(s.substring(startIndex, i + 1));
            backTracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
