package com.nathan.dynamicplan;

import org.junit.Test;

import java.util.Stack;

public class WiggleMaxLength376 {

    /**
     * 摆动序列
     * nums=[1,7,4,9,2,5] 时，演示如下：
     *        1     7    4
     *
     * up     1     2    2
     *           /     \
     * down   1     1   3
     *
     * */
    public int wiggleMaxLength(int[] nums) {
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return nums.length == 0 ? 0 : Math.max(down, up);
    }

    /**
     * 动态规划，使用两个 dp 记录上升序列和下降序列
     *
     * 分为 3 种情况
     * 1. nums[i + 1] > nums[i], 上升
     *    up[i] = Math.max(up[i - 1], down[i - 1] + 1)
     *    down[i] = down[i - 1]
     *
     * 2. nums[i + 1] < nums[i], 下降
     *    up[i] = up[i - 1]
     *    down[i] = Math.max(up[i - 1] + 1, down[i - 1])
     *
     * 3. 相等情况
     *    up[i] = up[i - 1]
     *    down[i] = down[i - 1]
     *
     * 返回两个序列最大值
     * */
    public int wiggleMaxLength4(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }

    /**
     * 贪心算法
     *
     * [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的
     *
     * 思路：记录当前差值及前一个差值，当其正负交替出现时符合摆动特性
     * */
    public int wiggleMaxLength3(int[] nums) {
        int curDiff;
        int preDiff = 0;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];

            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                res++;
                preDiff = curDiff;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{3, 3, 3, 3, 2, 5};
        wiggleMaxLength2(nums);
    }

    /**
     * 单调栈维持摆动特性
     *
     * */
    public int wiggleMaxLength2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        boolean currentUp = false;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > stack.peek()) {
                if (currentUp) {
                    stack.pop();
                    stack.push(nums[i]);
                } else {
                    currentUp = true;
                    stack.push(nums[i]);
                }
            } else if (nums[i] < stack.peek()) {
                if (!currentUp && stack.size() > 1) {
                    stack.pop();
                    stack.push(nums[i]);
                } else {
                    currentUp = false;
                    stack.push(nums[i]);
                }
            }
        }
        return stack.size();
    }

}
