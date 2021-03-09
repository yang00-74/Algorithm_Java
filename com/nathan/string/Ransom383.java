package com.nathan.string;

public class Ransom383 {

    /**
     * leetcode 383
     * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines
     * 里面的字符构成。如果可以构成，返回 true ；否则返回 false
     *
     * 杂志字符串中的每个字符只能在赎金信字符串中使用一次，且假设两个字符串均只含有小写字母
     *
     * */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] records = new int[26];

        for (char c : magazine.toCharArray()) {
            records[c - 'a'] += 1;
        }

        for (char c : ransomNote.toCharArray()) {
            records[c - 'a'] -= 1;
            if (records[c-'a'] < 0) {
                return false;
            }
        }
        return true;

    }
}
