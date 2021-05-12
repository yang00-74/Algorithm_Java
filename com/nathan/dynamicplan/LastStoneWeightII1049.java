package com.nathan.dynamicplan;

public class LastStoneWeightII1049 {
    /**
     * 有一堆石头，每块石头的重量都是正整数。
     *
     * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
     *
     * 如果 x == y，那么两块石头都会被完全粉碎；
     * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
     * 最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0
     *
     * 本题其实就是尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小，这样就化解成01背包问题了
     * 与 leetcode 416 题几乎一样，本题求背包最多能装多少
     * */
    public int lastStoneWeightII(int[] stones) {
        if (0 == stones.length) {
            return 0;
        }

        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }

        return sum - dp[target] - dp[target];
    }
}
