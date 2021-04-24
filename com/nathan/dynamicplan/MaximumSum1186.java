package com.nathan.dynamicplan;

public class MaximumSum1186 {

    /**
     * 给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。
     *
     * 换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。
     *
     * 注意，删除一个元素后，子数组 不能为空
     *
     *思路：
     *    动态规划
     *         dp[i][0]: 还没有删除过元素的最大和
     *         dp[i][1]: 删除了一个元素后的最大和
     * */
    public int maximumSum(int[] arr) {
        int[][] dp = new int[arr.length][2];
        dp[0][0] = arr[0];
        dp[0][1] = 0;
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = Math.max(dp[i][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i], dp[i][0]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }
}
