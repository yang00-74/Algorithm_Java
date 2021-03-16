package com.nathan.dynamicplan;

import java.util.Arrays;

public class MaxLengthOfConsecutiveSequence674 {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lengthOfLCIS(nums));
    }

    /**
     * 数组 [10,9,2,5,3,7,101,18] 其最长连续递增子序列为 [3,7,101] 长度为 3
     * 数组元素 dp[i] 表示数组中下标 i 的元素可以组成的最大连续递增序列长度
     * 则对于 nums[i] < nums[i + 1] 时，num[i + 1] 就能在 nums[1] 之后形成连续递增子序列，则 dp[i +1] = dp[i] + 1
     *
     * */
    public static int lengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            max = Math.max(max, dp[i + 1]);
        }
        return max;
    }
}
