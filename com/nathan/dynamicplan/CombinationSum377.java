package com.nathan.dynamicplan;

public class CombinationSum377 {

    /**
     * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数
     * 顺序不同的序列被视作不同的组合
     *
     * 完全背包问题，有顺序区别，故外层遍历背包，内层遍历物品
     * dp[i]: 凑成目标正整数为i的排列个数为dp[i]
     * */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
