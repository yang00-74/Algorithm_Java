package com.nathan.dynamicplan;

public class Rob213 {

    /**
     *你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
     * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额
     *
     * 对于一个数组，成环的话主要有如下三种情况：
     *
     * 情况一：考虑不包含首尾元素
     *
     * 情况二：考虑包含首元素，不包含尾元素
     *
     * 情况三：考虑包含尾元素，不包含首元素
     *
     * 注意这里用的是"考虑"，例如情况三，虽然是考虑包含尾元素，但不一定要选尾部元素！对于情况三，取nums[1] 和 nums[3]就是最大的。
     *
     * 而情况二 和 情况三 都包含了情况一了，所以只考虑情况二和情况三就可以了
     *
     * */
    public int rob(int[] nums) {
        if (0 == nums.length) {
            return 0;
        }

        if (1 == nums.length) {
            return nums[0];
        }

        int res1 = robRange(nums, 0, nums.length - 2);
        int res2 = robRange(nums, 1, nums.length - 1);
        return Math.max(res1, res2);
    }

    public int robRange(int[] nums, int start, int end) {
        // 只有2个房间的情况
        if (end == start) {
            return nums[start];
        }
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(dp[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
