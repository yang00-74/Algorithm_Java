package com.nathan.leetcode.editor.cn;
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 4885 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution42 {

    public static void main(String[] args) {
        new Solution42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        // 找出左右边界的最小值作为水位高度
        int hw = Math.min(height[left], height[right]);
        int total = 0;
        while (left < right) {
            // 如果左边较低，则左边界向右遍历， 否则右边界向左移动
            if (height[left] < height[right]) {
                left++;
                // 如果当前水高小于水位，则水量累加
                if (height[left] < hw) {
                    total += hw - height[left];
                } else {
                    // 否则，将此标尺和右边边界高度进行比较，找出剩下数组中的新水位
                    hw = Math.min(height[left], height[right]);
                }
            } else {
                right--;
                if (height[right] < hw) {
                    total += hw - height[right];
                } else {
                    hw = Math.min(height[left], height[right]);
                }
            }
        }
        return total;
    }

    public int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
