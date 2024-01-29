package com.nathan.leetcode.editor.cn;
/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 *
 * https://leetcode.cn/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (66.44%)
 * Likes:    1892
 * Dislikes: 0
 * Total Accepted:    468.1K
 * Total Submissions: 704.4K
 * Testcase Example:  '12'
 *
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11
 * 不是。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 12
 * 输出：3 
 * 解释：12 = 4 + 4 + 4
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 10^4
 * 
 * 
 */

import java.util.Arrays;

// @lc code=start
class Solution279 {
    /**
     * 完全背包问题，一个物品可以使用多次
     *
     * 1.确认下标含义
     * dp[i] 表示使用完全平方数叠加得到 i 的最小次数
     *
     * 2.确认状态转移方程
     * 对于 dp[i]，此处需要两层循环 j 在遍历，则 dp[i] 可以由 dp[i - j * j ] + 1 得到。由于 i 不变，
     * j 在遍历时 dp[i] 会多次赋值改变，要选择最小的dp[i]
     * 则 dp[i] = min(dp[i], dp[i -j*j] + 1)
     *
     * 3.确认初始状态
     * 对于 dp 要取最小值，则默认初始化所有下标为最大值，dp[0] = 0
     *
     * */
    public int numSquares(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        // 初始化最大
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int k;
            for (int j = 1; (k = j * j) <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - k] + 1);
            }
        }
        return dp[n];
    }
}
// @lc code=end

