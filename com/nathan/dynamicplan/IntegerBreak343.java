package com.nathan.dynamicplan;

public class IntegerBreak343 {

    /**
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积
     *
     * 思路：
     * 1. 确定dp数组（dp table）以及下标的含义
     * dp[i]：分拆数字i，可以得到的最大乘积为dp[i]。
     *
     * 2. 确定递推公式
     * 其实可以从1遍历j，然后有两种渠道得到dp[i].
     *
     * 一个是j * (i - j) 直接相乘。
     *
     * 一个是j * dp[i - j]，相当于是拆分(i - j)，对这个拆分不理解的话，可以回想dp数组的定义。
     *
     * 递推公式：dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j));
     *
     * 3.dp的初始化
     * dp[0] dp[1]应该初始化多少呢？
     * 拆分0和拆分1的最大乘积是多少？这是无解的。
     *
     * 这里只初始化dp[2] = 1，从dp[i]的定义来说，拆分数字2，得到的最大乘积是1
     *
     * 4.确定遍历顺序
     * 确定遍历顺序，先看递推公式：dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j));
     *
     * dp[i] 是依靠 dp[i - j]的状态，所以遍历i一定是从前向后遍历，先有dp[i - j]再有dp[i]。
     *
     * 枚举j的时候，从1开始，i从3开始，这样dp[i - j]就是dp[2]正好可以通过初始化的数值求出来
     * */
    public int integerBreak(int n) {
        if (n <= 1) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                // 遍历 j 时不断更新 dp[i]
                int currentMax = Math.max((i - j) * j, dp[i - j] * j);
                dp[i] = Math.max(dp[i], currentMax);
            }
        }
        return dp[n];
    }
}
