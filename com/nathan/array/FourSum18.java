package com.nathan.array;

import java.util.*;

public class FourSum18 {

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c d，使得 a + b + c + d 等于 target ，找出所有和为 target 且不重复的四元组
     * <p>
     * <p>
     * 1. 特判，对于数组长度 n，如果数组为 null 或者数组长度小于 4，返回 []
     * 2. 对数组进行排序
     * 3. 遍历排序后数组，两层循环先确定两个元素
     * 对于重复元素：跳过，避免出现重复解
     * 令左指针 L=i+1，右指针 R=n-1，当 L< R 时，执行循环：
     * 当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解，并同时将 L,R 移到下一位置，寻找新的解
     * 若和大于 0，说明 nums[R] 太大，R 左移
     * 若和小于 0，说明 nums[L] 太小，L 右移
     * <p>
     * <p>
     * 链接：https://leetcode-cn.com/problems/4sum
     */

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 4) {
            return result;
        }

        // 排序数组
        Arrays.sort(nums);

        for (int j = 0; j < nums.length; j++) {
            int first = nums[j];
            // 数组中相邻元素值如果相同，跳过去重
            if (j > 0 && nums[j - 1] == first) {
                continue;
            }
            for (int i = j + 1; i < nums.length; i++) {
                int second = nums[i];
                if (i > j + 1 && nums[i - 1] == second) {
                    continue;
                }

                int leftIndex = i + 1;
                int rightIndex = nums.length - 1;
                while (leftIndex < rightIndex) {
                    int sum = first + second + nums[leftIndex] + nums[rightIndex];
                    if (sum == target) {
                        result.add(Arrays.asList(first, second, nums[leftIndex], nums[rightIndex]));
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
                    } else if (sum > target) {
                        rightIndex--;
                    } else {
                        leftIndex++;
                    }
                }
            }
        }

        return result;
    }

    /**
     *给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0
     *
     * 链接：https://leetcode-cn.com/problems/4sum-ii
     *
     * 首先定义 一个 map，key 放 a 和 b 两数之和，value 放 a 和 b 两数之和出现的次数
     * 1. 遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到 map中
     * 2. 定义int变量count，用来统计a+b+c+d = 0 出现的次数
     * 3. 在遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就用count把map中key对应的value也就是出现次数统计出来
     * 4. 最后返回统计值 count 就可以了
     * */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                counter.put(a + b, counter.getOrDefault(a + b, 0) + 1);
            }
        }
        int result = 0;
        for (int c : C) {
            for (int d : D) {
                if (counter.containsKey(0 - c - d)) {
                    result += counter.get(0 - c - d);
                }
            }
        }
        return result;
    }

}
