package com.nathan.dynamicplan;

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
//        dp.spiltArray(0,5);
//        dp.canPartition(new int[]{1,2,5,6});
        System.out.println(dp.coinChange_dp(new int[]{1, 2, 5}, 12));
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

    // 判断数组是否可划分为和相等的两部分,动态规划,可看成一个背包大小为 sum/2 的 0-1 背包问题
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int W = sum / 2;
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;
        for (int num : nums) {
            System.out.println("the num is " + num);
            for (int i = W; i >= num; i--) {   // 从后往前，先计算 dp[i] 再计算 dp[i-num]
                dp[i] = dp[i] || dp[i - num];
                System.out.println("dp[" + i + "]:" + dp[i] + "," + "dp[" + (i - num) + "]:" + dp[i - num]);
            }
        }
        return dp[W];
    }


    /***
     * @param coins 硬币面值数组
     * @param amount 目标数额
     * @return 使用硬币凑出目标数额的最少硬币数
     * */
    public int coinChange(int[] coins, int amount) {
        // coins = [1, 2, 5], amount = 12
        if (amount == 0 || coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) { // 这是一个完全背包问题。完全背包需要将 0-1 背包中逆序遍历 dp 数组改为正序遍历,
                if (i == coin) {
                    dp[i] = 1;
                } else if (dp[i] == 0 && dp[i - coin] != 0) {
                    dp[i] = dp[i - coin] + 1;
                } else if (dp[i - coin] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            for (int i = 0; i <= amount;i++) {
                System.out.print("dp[" + i + "]:" + dp[i] + " ");
            }
            System.out.println();
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    // TODO
    public int coinChange_dp(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int k = 0; k <= amount; k++) {
                if (k >= coin) {
                    if (i == 0) {
                        dp[i][k] = dp[i][k - coin] + 1;
                    } else {
                        dp[i][k] = Math.min(dp[i][k], dp[i - 1][k - coin] + 1);
                    }
                }
            }
            for (int k = 0; k <= amount; k++) {
                System.out.print("dp[" + i + "]" + "[" + k + "]:"+ dp[i][k] + " ");
            }
            System.out.println();
        }

        return dp[coins.length - 1][amount];
    }

}
