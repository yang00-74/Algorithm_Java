package com.nathan.dynamicplan;

public class FindMaxForm474 {
    /**
     * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
     *
     * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1
     *
     * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
     * 输出：4
     *
     * 思路：01 背包
     *
     * 1.确定dp数组（dp table）以及下标的含义
     * dp[i][j]：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]。
     *
     * 2.确定递推公式
     * dp[i][j] 可以由前一个strs里的字符串推导出来，strs里的字符串有zeroNum个0，oneNum个1。
     *
     * dp[i][j] 就可以是 dp[i - zeroNum][j - oneNum] + 1。
     *
     * 然后我们在遍历的过程中，取dp[i][j]的最大值。
     *
     * 所以递推公式：dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
     * */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            char[] chars = str.toCharArray();
            // 统计每个字符串中 0、1的数量，可以将其看成物品重量
            int zeroNum = 0;
            int oneNum = 0;
            for (char c : chars) {
                if (c == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            // 01 背包，两个维度，更新dp 数组
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }

        }
        return dp[m][n];
    }
}
