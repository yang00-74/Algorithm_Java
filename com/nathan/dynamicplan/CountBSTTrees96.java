package com.nathan.dynamicplan;

public class CountBSTTrees96 {
    /**
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     *
     * 思路：动态规划
     * 假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数，则
     * G(n) = f(1) + f(2) + f(3) + f(4) + ... + f(n)
     *
     * 当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则
     * f(i) = G(i-1)*G(n-i)
     *
     * 综合两个公式可以得到 卡特兰数 公式
     * G(n) = G(0)*G(n-1)+G(1)*G(n-2)+...+G(n-1)*G(0)
     *
     * */
    public int numTrees(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= k; i++) {
                dp[k] += dp[i - 1] * dp[k - i];
            }
        }
        return dp[n];
    }

    /**
     * 卡塔兰数
     * C0=1,
     *
     * Cn+1= 2(2n+1) /（n+2）*Cn
     *
     * */
    public int numTrees2(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

}
