package com.nathan.dynamicplan;

import org.junit.Test;

public class MaxSubArray {



    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1, 3, 3, 4, 5, 6, 7};
        System.out.println(new MaxSubArray().maxSubArray2(nums));
    }

    /**
     * leet code 53
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
     *
     * */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxResult = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxResult = Math.max(dp[i], maxResult);
        }
        return maxResult;
    }

    public int maxSubArray2(int[] nums) {
        int dp = nums[0];
        int maxResult = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            dp = Math.max(dp + nums[i], nums[i]);
            maxResult = Math.max(dp, maxResult);
        }
        return maxResult;
    }

}
