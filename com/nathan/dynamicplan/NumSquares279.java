package com.nathan.dynamicplan;

import java.util.Arrays;

public class NumSquares279 {

    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     *
     * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
     *
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，
     * 而 3 和 11 不是
     *
     * 思路：动态规划，完全背包
     * 1. dp[i] 为组成正整数 i 的完全平方数的最小个数
     * 2. 对于 dp[i]，可以由dp[i - j * j]推出， dp[i - j * j] + 1 便可以凑成dp[i]。
     *   要选择最小的dp[i]，所以递推公式：dp[i] = min(dp[i - j * j] + 1, dp[i]);
     *
     * */
    public int numSquares(int n) {
        if ( n <= 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j * j <= i; j ++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
