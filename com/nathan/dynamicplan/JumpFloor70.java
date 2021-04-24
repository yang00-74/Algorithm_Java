package com.nathan.dynamicplan;

public class JumpFloor70 {
    /**
     * 剑指 Offer 10- II. 青蛙跳台阶问题
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
     *
     * 从第n个台阶进行下台阶，下一步有2中可能，一种走到第n-1个台阶，一种是走到第n-2个台阶。所以f[n] = f[n-1] + f[n-2].
     * 那么初始条件了，f[0] = f[1] = 1。
     * 所以就变成了：f[n] = f[n-1] + f[n-2], 初始值f[0]=1, f[1]=1，目标求f[n]
     * */
    public int jumpFloor(int target) {
        if (target == 0) {
            return 1;
        }
        int[] dp = new int[target + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[target];
    }
}
