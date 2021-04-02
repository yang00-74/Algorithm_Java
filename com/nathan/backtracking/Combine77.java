package com.nathan.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combine77 {
    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
     * */
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> comb = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return res;
    }

    public void backTracking(int n, int k, int startIndex) {
        if (comb.size() == k) {
            res.add(new ArrayList<>(comb));
            return;
        }
        // 剪枝优化，需要 k 个数，已经拿到了 comb.size() 个数
        // 则只要当前遍历的数大于  n - (k - comb.size()) + 1， 后面的数可能不能满足要求了
        for (int i = startIndex; i <= n - (k - comb.size()) + 1; i++) {
            comb.add(i);
            backTracking(n, k, i + 1);
            comb.remove(comb.size() - 1);
        }
    }
}
