package com.nathan.greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class MinArrowShots452 {

    @Test
    public void test() {
        int[][] points = new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        findMinArrowShots(points);
    }

    /**
     * 思路：求区间的交集数量
     *
     * 先按照区间左边界升序，遍历时分为两种情况
     *  1. 本区间的左边界如果小于上一个区间右边界则有重合，可以一箭射掉, 更新当前
     *
     * */
    public int findMinArrowShots(int[][] points) {
        if (0 == points.length) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));

        int count = 1;
        int currentRight = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > currentRight) {
                count++;
                // 更新当前右边界为不重叠区间的右边界
                currentRight = points[i][1];
            } else {
                // 更新当前区间的右边界为区间最小的右边界值
                currentRight = Math.min(points[i][1], currentRight);
            }
        }
        return count;
    }
}
