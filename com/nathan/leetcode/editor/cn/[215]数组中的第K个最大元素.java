package com.nathan.leetcode.editor.cn;
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 2355 👎 0


import static com.nathan.util.Util.swap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution215 {


    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(log⁡n)
     */
    public int quickSort(int[] nums, int left, int right, int k) {
        // 锚点
        int pivot = partitionASC(nums, left, right);
        if (pivot < k) {
            return quickSort(nums, pivot + 1, right, k);
        } else if (pivot > k) {
            // 目标元素在数组左半部分
            return quickSort(nums, left, pivot - 1, k);
        } else {
            return nums[pivot];
        }

    }

    public int partitionASC(int[] list, int left, int right) {
        // 用数组的第一个元素作为基准数
        int first = list[left];
        while (left < right) {
            while (left < right && list[right] >= first) {
                right--;
            }
            // 交换
            swap(list, left, right);

            while (left < right && list[left] <= first) {
                left++;
            }
            // 交换
            swap(list, left, right);
        }
        // 返回分割点所在的位置
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 6, 5, 4, 3, 2, 1,9};
        System.out.println(new Solution215().findKthLargest(nums, 1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
