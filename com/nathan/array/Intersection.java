package com.nathan.array;

import java.util.HashSet;
import java.util.Set;

public class Intersection {

    /**
     * leetcode 349 两个数组的交集
     * */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> targetSet = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int num : nums1) {
            targetSet.add(num);
        }
        for (int num : nums2) {
            if (targetSet.contains(num)) {
                result.add(num);
            }
        }
        int[] res = new int[result.size()];
        int index = 0;
        for (Integer num : result) {
            res[index++] = num;
        }
        return res;
    }
}
