package com.nathan.dynamicplan;

public class UniquePathsWithObstacles63 {

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     *
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * 网格中的障碍物和空位置分别用 1 和 0 来表示
     *
     * 思路：动态规划，但是初始化和状态转移时要考虑有障碍的情况
     * */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[m][n];

        // (i, 0) 这条边有了障碍之后，障碍之后（包括障碍）都是走不到的位置了，所以障碍之后的dp[i][0]应该还是初始值0
        for (int i = 0; i < m && obstacleGrid[i][0] != 1; i++) dp[i][0] = 1;
        for (int j = 0; j < n && obstacleGrid[0][j] != 1; j++) dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }

            }
        }
        return dp[m - 1][n - 1];

    }
}
