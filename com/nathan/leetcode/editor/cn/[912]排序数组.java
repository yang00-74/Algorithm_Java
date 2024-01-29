package com.nathan.leetcode.editor.cn;//给你一个整数数组 nums，请你将该数组升序排列。
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 104 
// -5 * 104 <= nums[i] <= 5 * 104 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 
// 👍 938 👎 0


import java.util.Arrays;

import static com.nathan.util.Util.swap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution912 {

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivot = partitionASC(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    public int partitionASC(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            swap(nums, left, right);

            while (left < right && nums[left] <= pivot) {
                left++;
            }
            swap(nums, left, right);
        }
        return left;
    }


    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9,7,8,6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(new Solution912().sortArray(nums)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
