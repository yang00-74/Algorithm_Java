package com.nathan.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination39 {

    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的数字可以无限制重复被选取。
     *
     * 说明：
     *
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。
     */

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0 || target <= 0) {
            return res;
        }
        backTracking(candidates, target, 0);
        return res;
    }

    public void backTracking(int[] candidates, int target, int startIndex) {
        if (target < 0) {
            return;
        }

        if (0 == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            target -= candidates[i];
            path.add(candidates[i]);
            backTracking(candidates, target, i);
            target += candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
