package com.nathan.array;

import org.junit.Test;

import java.util.Stack;

public class FindTargetAscElement {


    @Test
    public void test() {
        int[] nums = new int[]{10,8,101};
        printPivotElements(nums);
    }
    /**
     * 在无序不重复数组中寻找满足如下条件的元素:
     *
     * 该值左边的数均不大于它
     * 该值右边的数均不小于它
     *
     * 思路: 从右往左遍历，使用辅助数组记录每个下标上已经遍历过的数中最小的数
     *       再从左往右遍历，记录已经遍历过的数中最大的数，如果当前下标大于该数且小于辅助数组后一下标上记录的最小数，则其符合条件
     * */
    public int printPivotElements(int[] nums) {
        if (null == nums || nums.length < 3) {
            return -1;
        }
        int len = nums.length;
        // 从右往左，记录每个位置及其之后所有数中的最小数
        int[] rightMin = new int[len];
        int rMin = nums[len - 1];
        for (int i = len - 1; i >= 0; --i) {
            if (nums[i] < rMin) {
                rMin = nums[i];
            }
            rightMin[i] = rMin;
        }

        // 从左往右，寻找比左边最大数大且比右边最小数小的数
        int lMax = nums[0];
        for (int i = 1; i < len - 1; ++i) {
            if (nums[i] > lMax) {
                lMax = nums[i];
                if (nums[i] < rightMin[i + 1]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
