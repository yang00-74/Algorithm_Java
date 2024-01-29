package com.nathan.leetcode.editor.cn;
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 2784 👎 0


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution46 {

    /**
     * 时间复杂度：O(n×n!)，其中 n 为序列的长度
     * 空间复杂度：O(n)，n 为序列的长度。除答案数组以外，递归函数在递归过程中需要为每一层
     * 递归函数分配栈空间，所以这里需要额外的空间且该空间取决于递归的深度，这里可知递归调用深度为 O(n)。
     *
     * */

    private Deque<Integer> path = new LinkedList<>();
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return res;
        }
        // 记录此时path里都有哪些元素使用了，一个排列里一个元素只能使用一次
        boolean[] used = new boolean[nums.length];
        backTracking(nums, used);
        return res;
    }

    private void backTracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            // 2.nums 元素全都使用了，则找到一个解
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 1.元素未使用过
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                backTracking(nums, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
