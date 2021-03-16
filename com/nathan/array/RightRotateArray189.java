package com.nathan.array;

public class RightRotateArray189 {

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
     * <p>
     * 思路1：与字符串旋转类似，但是右旋需先整体旋转，再旋转局部
     * 思路2：借助队列，全部入队，再将尾部 k 个元素依次出队添加到队头
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int n = k % len;
        reverse(nums, 0, n - 1);
        reverse(nums, n, len - 1);
        reverse(nums, 0, len - 1);
    }

    public void reverse(int[] array, int left, int right) {
        while (left < right) {
            int temp = array[right];
            array[right] = array[left];
            array[left] = temp;
            left++;
            right--;
        }
    }
}
