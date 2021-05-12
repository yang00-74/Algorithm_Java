package com.nathan.dynamicplan;

public class FindTargetSumWays494 {

    /**
     *给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
     * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面
     *
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数
     *
     * 动态规划：01背包
     *   将数组分为左右两个部分 left - right = S，假设整数数组和为 sum，则有 left + right = sum
     *   故此，left - (sum -left) = S ---> left = (sum + S) / 2，需注意 (sum + S) 如果为奇数则无解，因为除以2会出现小数
     *
     *   1. dp[i] 表示使用一个物品时装满容量为 i 的背包的方法数， left >= i >= 物品 num
     *   2. 例如背包容量 i = 5，当前遍历到物品 nums[2] = 3，则 dp[5] 会等于之前遍历到上一个物品
     *   nums[1] = 2 时的 dp[5] 加上 dp[2] 的方法数
     *   也就是 dp[i] += dp[i - nums[k]]，
     *
     * */
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 此时无方案
        if (target > sum) {
            return 0;
        }
        // 背包容量为整数，sum+S为奇数的话不满足要求
        if (((sum + target) & 1) == 1) {
            return 0;
        }

        int bagSize = (sum + target) >> 1;

        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = bagSize; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[bagSize];
    }
}
