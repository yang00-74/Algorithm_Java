package com.nathan.dynamicplan;

public class FindLength718 {

    /**
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度
     *
     * */
    public int findLength(int[] A, int[] B) {
        int aLen = A.length;
        int bLen = B.length;
        int[][] dp = new int[aLen + 1][bLen + 1];
        int max = 0;
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
