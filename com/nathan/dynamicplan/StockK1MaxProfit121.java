package com.nathan.dynamicplan;

public class StockK1MaxProfit121 {

    /**
     * 只有一次买卖，则买入时的收益为当日股价的负数，不需要累加前一日收益
     *
     * dp[i][1] 为第 i 天持有股票的收益
     * dp[i][0] 为第 i 天不持有股票的收益
     */
    public int maxProfitK1(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[prices.length - 1][0];
    }


    // 贪心
    public int maxProfit2K1(int[] prices) {
        int res = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            res = Math.max(res, prices[i] - minPrice);
        }
        return res;
    }

}
