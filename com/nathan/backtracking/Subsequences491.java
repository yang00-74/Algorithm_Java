package com.nathan.backtracking;

import java.util.*;

public class Subsequences491 {
    /**
     * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2
     * */
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (0 == nums.length) {
            return res;
        }
        backTracking(nums, 0);
        return res;
    }

    public void backTracking(int[] nums, int startIndex) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }

        // 记录每层使用过的元素，用于去重
        Set<Integer> used = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (used.contains(nums[i]) || (!path.isEmpty() && nums[i] < path.getLast())) {
                continue;
            }
            used.add(nums[i]);
            path.addLast(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }

}
