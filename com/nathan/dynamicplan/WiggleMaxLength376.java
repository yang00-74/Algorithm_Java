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
