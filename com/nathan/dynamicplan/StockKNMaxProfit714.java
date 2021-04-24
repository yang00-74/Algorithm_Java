package com.nathan.dynamicplan;


public class StockKNMaxProfit714 {

    /**
     * 不限次买卖，则买入时的收益为当日股价的负数，需要累加前一日收益，卖出时需要交手续费
     * 思路1：
     *     动态规划  dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
     *             dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
     * */
    public int maxProfitKN(int[] prices, int fee) {

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }

}
