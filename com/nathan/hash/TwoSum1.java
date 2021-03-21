package com.nathan.hash;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    /**
     * leet code 1
     * 给定一个整数数组 nums 和一个整数目标值 target，在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标
     * */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            // 遍历时将当前元素与目标 target 的差值作为 key 存入，后续遍历如果遇到值为该差值的数组元素，则找到了
            map.put(target - nums[i], i);
        }
        return null;
    }
}
