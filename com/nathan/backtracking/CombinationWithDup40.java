package com.nathan.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationWithDup40 {

    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的数字可以被选取一次。
     *
     * 说明：
     *
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。
     */

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0 || target <= 0) {
            return res;
        }
        // 排序使相同元素相邻
        Arrays.sort(candidates);
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
            // 同一树层使用过的元素进行跳过，相邻元素如相等，不做处理
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            target -= candidates[i];
            path.add(candidates[i]);
            // 不可重复选用一个元素
            backTracking(candidates, target, i + 1);
            target += candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
