package com.nathan.dynamicplan;

import java.util.Arrays;

/**
 * @author Ye.Yang
 * @date 19-7-8 下午7:24
 **/
public class Knapsack {

    public static void main(String[] args) {

        Knapsack dp = new Knapsack();
        int[] weights = {1, 2, 3, 4};
        int[] values = {2, 4, 3, 6};

//        System.out.println("The max value:" + dp.knapsack(6, weights, values));
    }

    /**
     * 0-1 Knapsack.一个物品只能用一次
     *
     * 有一个容量为 W 的背包，要用这个背包装下物品的价值最大，这些物品有两个属性：体积 w 和价值 v。
     *
     * 定义一个二维数组 dp 存储最大价值，其中 dp[i][j] 表示前 i 件物品体积不超过 j 的情况下能达到的最大价值。设第 i 件物品体积为 w，价值为 v，
     * 根据第 i 件物品是否添加到背包中，可以分两种情况讨论：
     *
     * 1.第 i 件物品没添加到背包，总体积不超过 j 的前 i 件物品的最大价值就是总体积不超过 j 的前 i-1 件物品的最大价值，dp[i][j] = dp[i-1][j]。
     * 2.第 i 件物品添加到背包中，dp[i][j] = dp[i-1][j-w] + v
     *
     * dp[i][j] = max(dp[i-1][j-w] + v,dp[i-1][j])
     **/

    /**
     * @param W       背包最大体积容量
     * @param weights 物品体积数组 {1,2,3,4}
     * @param values  物品价值数组 {2,4,3,6}
     * @return 返回最大价值
     **/
    public int knapsack(int W, int[] weights, int[] values) {
        int length = weights.length;
        /*int[][] dp = new int[length + 1][W + 1];
        for (int i = 1; i <= length; i++) { // 物品数组循环
            int w = weights[i - 1];
            int v = values[i - 1];
            for (int j = 1; j <= W; j++) { // 物品体积循环
                if (j >= w) { // 第 i 个物品加入背包
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[length][W];*/

        int[] dp = new int[W + 1]; // 一维数组优化
        for (int i = 1; i <= length; i++) { // 物品数组循环
            int w = weights[i - 1];
            int v = values[i - 1];
            for (int j = W; j >= 1; j--) { // 0-1 背包问题一维数组表示需逆序遍历,否则之前的计算结果会对之后的结果造成影响
                if (j >= w) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);

                }
            }
            for(int j =0; j<= W;j++) {
                System.out.print("dp[" + j + "]:" + dp[j] +" ");
            }
            System.out.println();
        }
        return dp[W];
    }

}
