package com.nathan.dynamicplan;

public class LongestCommonSubsequence1143 {
    /**
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度
     *
     * 1. 确定dp数组（dp table）以及下标的含义
     * dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
     *
     * 2. 确定递推公式
     * 主要就是两大情况：text1[i - 1] 与 text2[j - 1]相同，text1[i - 1] 与 text2[j - 1]不相同
     *
     * 如果text1[i - 1] 与 text2[j - 1]相同，那么找到了一个公共元素，所以dp[i][j] = dp[i - 1][j - 1] + 1;
     *
     * 如果text1[i - 1] 与 text2[j - 1]不相同，那就看看text1[0, i - 2]与text2[0, j - 1]的最长公共子序列
     * 和 text1[0, i - 1]与text2[0, j - 2]的最长公共子序列，取最大的。
     *
     * 即：dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
     *
     * 3. dp数组如何初始化
     * 先看看dp[i][0]应该是多少呢？
     *
     * test1[0, i-1]和空串的最长公共子序列自然是0，所以dp[i][0] = 0;
     *
     * 同理dp[0][j]也是0。
     *
     * 其他下标都是随着递推公式逐步覆盖，初始为多少都可以，那么就统一初始为0
     * */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
