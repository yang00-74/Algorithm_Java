package com.nathan.dynamicplan;

public class LongestPalindromeSubseq516 {

    /**
     *
     * 1. 确定dp数组（dp table）下标含义
     * dp[i][j]：字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]
     *
     * 2. 确定递推公式
     * 如果s[i]与s[j]相同，那么dp[i][j] = dp[i + 1][j - 1] + 2;
     * 如果s[i]与s[j]不相同，说明s[i]和s[j]的同时加入 并不能增加[i,j]区间回文子串的长度，
     * 那么分别加入s[i]、s[j]看看哪一个可以组成最长的回文子序列。
     *
     * 那么dp[i][j]一定是取最大的，即：dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
     *
     * 3. dp数组如何初始化
     * 从递推公式：dp[i][j] = dp[i + 1][j - 1] + 2; 可以看出 递推公式是计算不到 i 和j相同时候的情况。
     * 所以需要手动初始化一下，当i与j相同，那么dp[i][j]一定是等于1的，即：一个字符的回文子序列长度就是1。
     * 其他情况dp[i][j]初始为0就行
     *
     * 4. 确定遍历顺序
     * 从递推公式dp[i][j] = dp[i + 1][j - 1] + 2 和 dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]) 可以看出，
     * dp[i][j]是依赖于dp[i + 1][j - 1] 和 dp[i + 1][j]，也就是依赖下一行的数据。 所以遍历i的时候一定
     * 要从下到上遍历，这样才能保证下一行的数据是经过计算的
     *
     * */
    public int longestPalindromeSubseq(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
