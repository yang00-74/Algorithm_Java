package com.nathan.dynamicplan;

public class UniquePaths62 {
    /**
     * 一个机器人在m×n大小的地图的左上角（起点）。
     * 机器人每次向下或向右移动。机器人要到达地图的右下角（终点）。
     * 可以有多少种不同的路径从起点走到终点
     *
     * 动态规划，对于地图点 （i, j）, 可以从 （i-1, j） 和 （i, j -1）到达
     * */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
