package com.nathan.dynamicplan;


public class StockKNMaxProfitWithFrozen309 {

    /**
     * 不限次买卖，则买入时的收益为当日股价的负数，需要累加前一日收益，卖出后需要冷冻期 1 天才能买入
     *
     * 思路：股票卖出后必须要隔一天才能再卖，则卖出时获得收益依赖当天之前的第 2 天转移而来
     *     动态规划  dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
     *               dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
     * */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(0, dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);
        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }

    public int maxProfitWithFrozen(int[] prices) {
        int n = prices.length;
        int dpi0 = 0;
        int dpi1 = Integer.MIN_VALUE;
        int dpPre0 = 0; // 代表 dp[i-2][0]
        for (int i = 0; i < n; i++) {
            int temp = dpi0;
            dpi0 = Math.max(dpi0, dpi1 + prices[i]);
            dpi1 = Math.max(dpi1, dpPre0 - prices[i]);
            dpPre0 = temp;
        }
        return dpi0;
    }

}
