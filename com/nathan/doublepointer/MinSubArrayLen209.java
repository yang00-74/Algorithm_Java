package com.nathan.doublepointer;

public class MinSubArrayLen209 {

    /**
     * leet code 209
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
     * 如果不存在符合条件的子数组，返回 0
     *
     * 双指针，前指针不断往后移动，叠加其经过的元素的值，当统计值大于等于目标值时，后指针向后移动，并减去后指针对应元素值，
     * 计算取前后指针相差最小的值
     * */
    public int minSubArrayLen( int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                int subLen = right - left + 1;
                result = Math.min(result, subLen);
                sum -= nums[left++];
            }

        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
