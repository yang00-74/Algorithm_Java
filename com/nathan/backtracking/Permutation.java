package com.nathan.backtracking;

import java.util.*;

public class Permutation {
    /**
     * 剑指 Offer 38. 字符串的排列
     *
     * 给定字符串，输出该字符串所有单个字符重新排列的不重复的字符串
     * */
    private Set<String> res = new HashSet<>();
    private Deque<Character> path = new ArrayDeque<>();

    public String[] permutation(String str) {
        if (str == null || str.length() == 0) {
            return res.toArray(new String[0]);
        }

        boolean[] used = new boolean[str.length()];
        backTracking(str.toCharArray(), used);

        return res.toArray(new String[res.size()]);
    }

    public void backTracking(char[] chars, boolean[] used) {
        if (path.size() == chars.length) {
            StringBuilder sb = new StringBuilder();
            for (Character c : path) {
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.addLast(chars[i]);
                backTracking(chars, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }

    public ArrayList<String> permutation2(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        TreeSet<String> set = new TreeSet<>();
        range(str.toCharArray(), 0, set);

        result.addAll(set);
        Collections.sort(result);//工具类排序
        return result;
    }

    public void range(char[] chars, int pos, Set<String> set) {
        if (pos == chars.length - 1) {
            set.add(new String(chars));
            return;
        }
        for (int i = pos; i < chars.length; i++) {
            swap(chars, i, pos);
            range(chars, pos + 1, set);
            swap(chars, i, pos);
        }
    }

    void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }
}
