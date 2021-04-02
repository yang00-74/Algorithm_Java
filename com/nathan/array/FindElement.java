package com.nathan.array;

import java.util.Stack;

public class FindElement {
    /**
     * 在无序不重复数组中寻找满足如下条件的元素:
     *
     * 该值左边的数均不大于它
     * 该值右边的数均不小于它
     *
     * 思路1: 单调递增栈，当栈顶的元素比当前遍历的元素大，则说明栈顶元素不符合要求，出栈, while 比较
     * 思路2: 从右往左遍历，使用辅助数组记录每个下标上已经遍历过的数中最小的数
     *       再从左往右遍历，记录已经遍历过的数中最大的数，如果当前下标大于该数其小于辅助数组后一下标上记录的最小数，则其符合条件
     * */
    private int[] midValue(int[] nums) {
        if (0 == nums.length) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] <= stack.peek()) {
                stack.pop();
            }
            stack.add(nums[i]);
        }

        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    public void printPivotElements(int[] nums, int len) {
        // 从右往左，记录每个位置及其之后的最小数
        int[] rightMin = new int[len];
        int rMin = nums[len - 1];
        for (int i = len - 1; i >= 0; --i) {
            if (nums[i] < rMin) {
                rMin = nums[i];
            }
            rightMin[i] = rMin;
        }

        // 从左往右，寻找比左边大且比右边最小数小的数
        int lMax = nums[0];
        for (int i = 1; i < len - 1; ++i) {
            if (nums[i] > lMax) {
                lMax = nums[i];
                if (nums[i] < rightMin[i + 1]) {
                    System.out.println(nums[i]);
                }
            }
        }
    }
}
