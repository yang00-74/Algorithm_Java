package com.nathan.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Combine216 {


    @Test
    public void test() {
        List<List<Integer>> res = combinationSum3(7, 3);
        System.out.println(res.toString());
    }

    /**
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字
     */
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> comb = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n, k, 1);
        return res;
    }

    public void backTracking(int target, int k, int startIndex) {
        // 剪枝优化
        if (target < 0) {
            return;
        }
        if (comb.size() == k) {
            if (0 == target) {
                res.add(new ArrayList<>(comb));
            }
            return;
        }
        for (int i = startIndex; i <= 9 && i <= target; i++) {
            comb.add(i);
            backTracking(target - i, k, i + 1);
            comb.remove(comb.size() - 1);
        }
    }
}
