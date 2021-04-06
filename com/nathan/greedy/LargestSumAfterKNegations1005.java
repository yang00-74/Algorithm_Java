package com.nathan.greedy;

import java.util.Arrays;

public class LargestSumAfterKNegations1005 {

    /**
     * K 次取反后最大化的数组和
     *
     * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。
     * （我们可以多次选择同一个索引 i。）
     *
     * 以这种方式修改数组后，返回数组可能的最大和
     *
     * */
    public int largestSumAfterKNegations(int[] A, int K) {
        if (0 == A.length) {
            return 0;
        }
        // 首先排序数组
        Arrays.sort(A);

        int minIndex = 0;
        while (K > 0) {
            A[minIndex] = -A[minIndex];
            K--;
            // 维护最小值索引
            // 若后面还有数，则看当前的与下一个谁更小
            if (minIndex + 1 < A.length && A[minIndex] > A[minIndex + 1]) {
                minIndex += 1;
            }
        }
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        return sum;
    }
}
