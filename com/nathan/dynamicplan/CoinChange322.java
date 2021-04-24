package com.nathan.dynamicplan;

import org.junit.Test;

import java.util.Arrays;

public class CoinChange322 {

    @Test
    public void test() {
        int[] coins = new int[]{2, 5, 1};
        int amount = 12;
        coinChange(coins, amount);
    }

    /***
     * @param coins 硬币面值数组
     * @param amount 目标数额
     * @return 使用硬币凑出目标数额的最少硬币数
     *
     * 1. dp[i] 表示组成面额 i 使用的最少的硬币数
     * 2. dp[i] = min(dp[i], dp[i - coins[j]] + 1)
     * 3. 初始化 dp[0] = 0,表示组成 面额 0 最少需要 0 个硬币，因为要取最小值，故其他位置初始化为极大值，
     *    否则递推过程中所有位置都会取到 0
     * */
    public int coinChange(int[] coins, int amount) {
        // coins = [1, 2, 5], amount = 12
        if (amount == 0 || coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            // 这是一个完全背包问题。完全背包需要将 0-1 背包中逆序遍历 dp 数组改为正序遍历
            for (int i = coin; i <= amount; i++) {
                // 如果dp[j - coins[i]]未被更新过还是初始值，说明当前遍历过的硬币中还无法凑出这个面额，跳过
                if (dp[i - coin] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
