package com.nathan.dynamicplan;

public class CoinChange518 {
    /**
     *给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个
     *
     * 动态规划，完全背包
     * 1. 确定dp数组以及下标的含义
     * dp[j]：凑成总金额j的货币组合数为dp[j]
     *
     * 2. 确定递推公式
     * dp[j] （考虑coins[i]的组合总和） 就是所有的dp[j - coins[i]]（不考虑coins[i]）相加。
     *
     * 所以递推公式：dp[j] += dp[j - coins[i]];
     * */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
