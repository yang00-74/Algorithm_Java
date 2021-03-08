package com.nathan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ，找出所有和为 0 且不重复的三元组
     * <p>
     *
     * 1. 特判，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []
     * 2. 对数组进行排序
     * 3. 遍历排序后数组：
     *    若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0 直接返回结果
     *    对于重复元素：跳过，避免出现重复解
     *   令左指针 L=i+1，右指针 R=n-1，当 L< R 时，执行循环：
     *     当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解，并同时将 L,R 移到下一位置，寻找新的解
     *     若和大于 0，说明 nums[R] 太大，R 左移
     *     若和小于 0，说明 nums[L] 太小，L 右移
     *
     *
     * 链接：https://leetcode-cn.com/problems/3sum
     */

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 3) {
            return result;
        }

        // 排序数组
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            // 排序后数组头部的值大于 0， 则整个数组中不可能存在 a + b + c = 0
            if (current > 0) {
                break;
            }
            // 数组中相邻元素值如果相同，跳过去重
            if (i > 0 && nums[i - 1] == current) {
                continue;
            }
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                int sum = current + nums[leftIndex] + nums[rightIndex];
                if (sum == 0) {
                    result.add(Arrays.asList(current, nums[leftIndex], nums[rightIndex]));
                    // 左指针去重
                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) {
                        leftIndex++;
                    }
                    // 右指针去重
                    while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1]) {
                        rightIndex--;
                    }
                    leftIndex++;
                    rightIndex--;
                } else if (sum > 0) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }
            }
        }

        return result;
    }

}
