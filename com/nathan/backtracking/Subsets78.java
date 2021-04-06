package com.nathan.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Subsets78 {

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     *
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集
     *
     * 收集树的所有节点
     * */
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> subsets(int[] nums) {
        if ( 0 == nums.length) {
            return res;
        }
        backTracking(nums, 0);
        return res;
    }

    public void backTracking(int[] nums, int startIndex) {
        // 收集所有子集
        res.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }

        for(int i = startIndex; i < nums.length; i ++) {
            path.addLast(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }
}
