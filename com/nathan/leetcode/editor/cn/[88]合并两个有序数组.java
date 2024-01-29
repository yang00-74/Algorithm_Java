package com.nathan.leetcode.editor.cn;
//给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
//
// 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。 
//
// 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并
//的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//解释：需要合并 [1,2,3] 和 [2,5,6] 。
//合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
//解释：需要合并 [1] 和 [] 。
//合并结果是 [1] 。
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0], m = 0, nums2 = [1], n = 1
//输出：[1]
//解释：需要合并的数组是 [] 和 [1] 。
//合并结果是 [1] 。
//注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[j] <= 109 
// 
//
// 
//
// 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？ 
// Related Topics 数组 双指针 排序 
// 👍 2237 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution88 {

    /**
     * 使用 3 个指针记录数组关键下标：
     * p1 -> nums1 数组尾部
     * p2 -> nums2 数组尾部
     * p -> 最终数组尾部
     * 1.当 p1 >= 0 时，nums1[p1], nums2[p2]对比
     * A. nums1[p1]大，将 nums1[p1] 放入 nums1[p] 位置, p1--, p--
     * B. nums2[p2]大于等于 nums1[p1]，将nums2[p2]放入 nums1[p] 位置, p2--, p--
     * 2.当 p1 < 0 时，将 nums2[p2]放入 nums1[p] 位置, p2--,p--
     * 循环结束：p2<0，因为 nums2 数组中的元素必须都移动到 nums1
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        int pe1 = m - 1;
        int pe2 = n - 1;
        int pe = m + n - 1;
        while (pe2 >= 0) {
            if (pe1 >= 0 && nums1[pe1] >= nums2[pe2]) {
                nums1[pe--] = nums1[pe1--];
            } else {
                nums1[pe--] = nums2[pe2--];
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
