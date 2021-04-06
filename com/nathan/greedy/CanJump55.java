package com.nathan.greedy;

public class CanJump55 {
    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个下标
     *
     *
     * 思路：
     * 只要存在一个位置 x，它本身可以到达，并且它跳跃的最大位置为 x+nums[x]，这个值大于等于 y，即 x+nums[x]≥y，则位置 y 也可以到达
     *
     * 这样依次遍历数组中的每一个位置，并实时维护 最远可以到达的位置。对于当前遍历到的位置 x，如果它在 最远可以到达的位置 的范围内，
     * 那么就可以从起点通过若干次跳跃到达该位置，因此可以用 x+nums[x] 更新 最远可以到达的位置。
     *
     * 在遍历的过程中，如果 最远可以到达的位置 大于等于数组中的最后一个位置，那就说明最后一个位置可达，我们就可以直接返回 True 作为答案
     *
     * 这道题关键点在于：不用拘泥于每次究竟跳几步，而是看覆盖范围，覆盖范围内已经是可以跳过来的，不用管是怎么跳的
     * */
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= right) {
                right = Math.max(i + nums[i], right);
                if (right >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
