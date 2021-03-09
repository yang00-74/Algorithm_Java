package com.nathan.dynamicplan;

import java.util.Arrays;

public class MaxLengthOfAscSequence300 {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lengthOfLIS(nums));
    }

    /**
     * 数组 [10,9,2,5,3,7,101,18] 其最长递增子序列为 [2,3,7,101] 或者 [2,5,7,101], 长度为 4
     * 数组元素 dp[i] 表示数组中下标 i 的元素可以组成的最大递增序列长度
     * 则对于 nums[j] < nums[i] 时，num[i] 就能在 nums[j] 之后形成递增子序列，则 dp[i] = max(dp[i], dp[j] + 1)
     *  0 < j < i
     *
     * */
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 1;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
