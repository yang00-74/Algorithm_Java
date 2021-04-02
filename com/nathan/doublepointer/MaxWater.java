package com.nathan.doublepointer;

public class MaxWater {

    public long trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        long sum = 0;
        // 找出左右边界的最小值作为水位高度
        int mark = Math.min(height[left], height[right]);
        while (left < right) {
            // 如果左边较低，则左边界向右遍历， 否则右边界向左移动
            if (height[left] < height[right]) {
                left++;
                // 如果当前标尺小于水位，则水量累加
                if (height[left] < mark) {
                    sum += mark - height[left];
                } else {
                    // 否则，将此标尺和右边边界高度进行比较，找出剩下数组中的新水位
                    mark = Math.min(height[left], height[right]);
                }
            } else {
                right--;
                // 同理，如果当前标尺小于水位，则水量累加
                if (height[right] < mark) {
                    sum += mark - height[right];
                } else {
                    // 否则，将此标尺和左边界的高度进行比较，找出剩余数组中的新水位
                    mark = Math.min(height[right], height[left]);
                }
            }
        }
        return sum;
    }
}
