package com.nathan.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalsMerge56 {

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间
     *
     * 思路：
     *    1. 将区间的左边界排序
     *    2. 将第一个区间加入 res 数组中，并按顺序依次考虑之后的每个区间：
     *      如果当前区间的左端点在数组 res 中最后一个区间的右端点之后，那么它们不会重合，可以直接将这个区间加入数组 res 的末尾；
     *      否则，它们重合，需要用当前区间的右端点更新数组 res 中最后一个区间的右端点，将其置为二者的较大值。
     */
    public int[][] merge(int[][] intervals) {

        // 区间按照左边界排序
        Arrays.sort(intervals, (interval1, interval2) -> {
            if (interval1[0] == interval2[0]) {
                return interval1[1] - interval2[1];
            }
            return interval1[0] - interval2[0];
        });

        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            // 当前区间左边界大于 res 最后一个区间的右边界之后，那么它们不会重合，无法合并
            if (res.size() == 0 || left > res.get(res.size() - 1)[1]) {
                res.add(new int[]{left, right});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], right);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}