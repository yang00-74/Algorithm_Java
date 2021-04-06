package com.nathan.dynamicplan;


public class StockKNMaxProfit122 {

    /**
     * 不限次买卖，则买入时的收益为当日股价的负数，需要累加前一日收益
     * 思路1：
     *     动态规划  dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
     *             dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
     * */
    public int maxProfitKN(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }

    /**
     * 思路2：贪心算法
     *
     * 收集每天的正利润就可以，「收集正利润的区间，就是股票买卖的区间，而我们只需要关注最终利润，不需要记录区间」。
     *
     * 只收集正利润就是贪心所贪的地方
     *
     * 局部最优：收集每天的正利润，全局最优：求得最大利润
     * */
    public int maxProfitKN2(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(prices[i] - prices[i - 1], 0);
        }

        return res;
    }

}
