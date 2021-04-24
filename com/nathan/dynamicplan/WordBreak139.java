package com.nathan.dynamicplan;

import java.util.List;

public class WordBreak139 {

    /**
     *给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     *
     * 说明：
     *
     * 拆分时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     * 示例 1：
     *
     * 动态规划，完全背包
     * 1.确定dp数组以及下标的含义
     * dp[i] : 字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词。
     *
     * 2.确定递推公式
     * 如果确定dp[j] 是true，且 [j, i] 这个区间的子串出现在字典里，那么dp[i]就是true。（j < i ）。
     *
     * 所以递推公式是 if([j, i] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true。
     * */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (null == s || "".equals(s)) {
            return true;
        }

        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                // 当 0-j 位置的子字符串可以在字典中找到，并且 j-i 位置的子字符串可以在字典中找到，
                // 可以推出 0-i 位置的子字符串必然是可以在字典中找到的
                if (dp[j] && wordDict.contains(sub)) {
                    dp[i] = true;
                }
            }
        }

        return dp[len];
    }

}
