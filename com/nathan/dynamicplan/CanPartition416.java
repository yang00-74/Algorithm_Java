package com.nathan.dynamicplan;

public class CanPartition416 {


    // 判断数组是否可划分为和相等的两部分,动态规划,可看成一个背包大小为 sum/2 的 0-1 背包问题
    public boolean canPartition(int[] nums) {
        if (0 == nums.length) {
            return true;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        int[] dp = new int[target + 1];

        for (int num: nums) {
            // 0/1 背包从后往前遍历，相当于每个物品只使用了一次
            for (int i = target; i >= num; i --) {
                dp[i] = Math.max(dp[i], dp[i - num ] + num);
            }
        }

        return dp[target] == target;
    }

}
