package com.nathan.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class IntervalsEraseOverlap435 {

    /**
     * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠
     *   可以认为区间的终点总是大于它的起点。
     *   区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠
     *
     * 思路：找到不重叠的区间的个数，然后用区间总数减去其值，即为需要移除的区间数量
     * */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        // 按照区间右边界排序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        int count = 1;
        // 初始右边界
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前的右边界小于等于下一个区间的左边界，则不重叠，计数器自增，同时更新当前右边界
            if (right <= intervals[i][0]) {
                right = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;
    }
}
