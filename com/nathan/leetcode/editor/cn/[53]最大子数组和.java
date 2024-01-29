package com.nathan.leetcode.editor.cn;
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 
// 👍 6484 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution53 {
    /**
     * 1. 定义状态
     * dp[i] 表示在 i 位置上，最大的子数组和
     *
     * 2. 状态转移
     * 对于 dp[i]，其值由 nums[i] 和 dp[i -1] 决定，考虑以下情况
     * a.nums[i]加入当前连续子序列和：dp[i - 1] + nums[i]
     * b.从头开始计算当前连续子序列和：nums[i]
     *
     * 3.初始化
     * dp[] 默认都为 0 即可
     *
     * 4.输出
     * 由于需要输出最大值，则需要记录在各个位置上出现过的最大值的 max
     *
     **/
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
