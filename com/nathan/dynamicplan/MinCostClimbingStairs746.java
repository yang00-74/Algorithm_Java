package com.nathan.dynamicplan;

public class MinCostClimbingStairs746 {
    /**
     * 使用最小花费爬楼梯
     *
     * dp[i] 表示爬到第 i 层花费的最少体力, 其可以从 i -1 或者 i-2 层抵达
     * 故 ： dp[i] = Math.min(dp[i - 1] + cost[i -1], dp[i - 2] + cost[i-2])
     *
     * 初始化：dp[0], dp[1] 不需要花费就可以抵达，故其初始化为 0
     * */
    public int minCostClimbingStairs(int[] cost) {
        if (0 == cost.length) {
            return 0;
        }

        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i -1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }

    public int minCostClimbingStairs2(int[] cost) {
        if (0 == cost.length) {
            return 0;
        }

        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
