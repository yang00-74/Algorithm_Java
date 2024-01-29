package com.nathan.leetcode.editor.cn;
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 
// 👍 3487 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution300 {
    /**
     * 1.确定状态
     * dp[i] 表示在 i 位置上的最长的递增子序列长度
     *
     * 2.状态转移
     * dp[i] 依赖 num[i] 和 dp[j]，如果 nums[i] > nums[j] 则
     * dp[i] = max(dp[i], dp[j] + 1) 否则，dp[i] 不需要更新，其中 j < i
     *
     * 3.初始化
     * 单个的数字自成长度为 1 的序列，dp[] 初始化填充 1
     *
     * 4.输出结果
     * 取整个序列上的最长的递增序列长度，则需要使用 max 记录
     * */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        int res = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
