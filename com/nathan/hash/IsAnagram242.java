package com.nathan.hash;

public class IsAnagram242 {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
     * */
    public boolean isAnagram(String s, String t) {
        if (null == s || 0 == s.length()) {
            return null == t || t.length() == 0;
        }
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            counter[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
