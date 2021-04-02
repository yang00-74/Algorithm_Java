package com.nathan.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permute46 {

    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列
     * */
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> permute(int[] nums) {
        if (0 == nums.length) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        backTracking(nums, used);
        return res;
    }

    public void backTracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        //  排列问题，每次都要从头开始搜索
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.addLast(nums[i]);
                backTracking(nums, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
