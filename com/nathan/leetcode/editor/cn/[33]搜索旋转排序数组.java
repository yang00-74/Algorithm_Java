package com.nathan.leetcode.editor.cn;
//整数数组 nums 按升序排列，数组中的值 互不相同 。
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -104 <= target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 2809 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution33 {
    /**
     * 复杂度分析
     * <p>
     * 时间复杂度： O(log⁡n)。整个算法时间复杂度即为二分查找的时间复杂度
     * <p>
     * 空间复杂度： O(1)
     */
    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }

        if (1 == nums.length) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0;
        int r = nums.length - 1;
        // [7,9,10,0,1,2,4,5,6], target = 0
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 中间值大于左边界，说明左边是有序的
            if (nums[mid] >= nums[0]) {
                // 在左半边
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    // 不在左半边
                    l = mid + 1;
                }
            } else {
                // 中间值小于左边界，说明 mid 位置在右边有序的部分内
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    // target 在右边有序部分内
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
