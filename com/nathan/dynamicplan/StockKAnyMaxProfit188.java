package com.nathan.dynamicplan;


public class StockKAnyMaxProfit188 {

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
     * 限次买卖，如果 k 大于 天数/2，可以近似认为不限次
     *
     * */
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if ( 0 == len) {
            return 0;
        }
        if (k > len / 2) {
            return maxProfitKN(prices);
        }

        int[][][] dp = new int[len][k + 1][2];
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }
        return dp[len - 1][k][0];

    }

}
