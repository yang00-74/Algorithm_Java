package com.nathan.dynamicplan;

public class SubSequence392 {

    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     *
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
     * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）
     *
     * 1.确定dp数组（dp table）以及下标的含义
     * dp[i][j] 表示以下标i-1为结尾的字符串s，和以下标j-1为结尾的字符串t，相同子序列的长度为dp[i][j]
     *
     * 2. 确定递推公式
     * 在确定递推公式的时候，首先要考虑如下两种操作，整理如下：
     *
     * if (s[i - 1] == t[j - 1]) t中找到了一个字符在s中也出现了,那么dp[i][j] = dp[i - 1][j - 1] + 1
     * if (s[i - 1] != t[j - 1]) 相当于t要删除元素，继续匹配,即：dp[i][j] = dp[i][j - 1]
     *
     * 3. 初始化数组
     * dp[i][j]都是依赖于dp[i - 1][j - 1] 和 dp[i][j - 1]，所以dp[0][0]和dp[i][0]是一定要初始化的, 初始化为 0 即可
     * 相当于在 dp 数组中留出了一部分空间
     * * */
    public boolean isSubsequence(String s, String t) {
        if (null == s) {
            return null == t;
        }
        int lens = s.length();
        int lent = t.length();
        int[][] dp = new int[lens + 1][lent + 1];
        for (int i = 1; i <= lens; i++) {
            for (int j = 1; j <= lent; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[lens][lent] == lens;
    }
}
