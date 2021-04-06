package com.nathan.greedy;

public class Jump45 {
    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置，数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置
     *
     * 思路：以最小的步数增加最大的覆盖范围，直到覆盖范围覆盖了终点
     *     如果移动下标达到了当前这一步的最大覆盖最远距离了，还没有到终点的话，那么就必须再走一步来增加覆盖范围，直到覆盖范围覆盖了终点
     * */
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        // 当前覆盖的右边界下标
        int right = 0;
        // 下一步覆盖的最远右边界下标
        int nextRight = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextRight = Math.max(i + nums[i], nextRight);
            // 到达边界，步数自增，更新边界值为最远的下一个边界
            // 如果遍历的下标抵达倒数第 2 的位置，则下一步必然是能抵达终点的，故下标 i 最大值为 (nums.length - 2)
            if (i == right) {
                step++;
                right = nextRight;
            }
        }
        return step;
    }
}
