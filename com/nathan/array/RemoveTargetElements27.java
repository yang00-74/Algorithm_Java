package com.nathan.array;

public class RemoveTargetElements27 {
    /**
     * 给定一个数组 nums 和一个值 val，原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度
     *
     * 不要使用额外的数组空间，必须仅使用 O(1) 额外空间并 原地 修改输入数组
     *
     * 元素的顺序可以改变，不需要考虑数组中超出新长度后面的元素
     *
     * 解法：
     *  双指针，慢指针只在 nums[i] ！= val 的时候才向前移动，并将快指针指向的元素赋值到慢指针位置
     *
     * 链接：https://leetcode-cn.com/problems/remove-element
     * */

    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[slowIndex++] = nums[i];
            }
        }
        return slowIndex;
    }
}
