package com.nathan.leetcode.editor.cn;
//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 2555 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int startIndex = searchFirstIndex(nums, target);
        if (startIndex == -1) {
            return new int[]{-1, -1};
        }
        if (startIndex >= nums.length - 1) {
            return new int[]{startIndex, startIndex};
        }

        int endIndex = searchSndIndexFrom(nums, startIndex, target);
        return new int[]{startIndex, endIndex};
    }

    public int searchSndIndexFrom(int[] nums, int startIndex, int target) {
        int left = startIndex;
        int right = nums.length - 1;
        int ans = startIndex;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 不断向右逼近目标值最后一次出现的位置
                left = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }

    public int searchFirstIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                // 不断向左逼近目标值第一次出现的位置
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
